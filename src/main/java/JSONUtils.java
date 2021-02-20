import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


/**
 * @Author: mengchao
 * @Date: 2021/1/27 11:43
 */
public class JSONUtils {
    public static final int DUPLICATED_VALUE_TRUE = 1;
    public static final int DUPLICATED_VALUE_FALSE = 2;

    public static void main(String[] args) {
        String s = "{\"aftertype2\":{},\"aftertype1\":[{\"lesion1_std\":\"左肺\",\"lesion_type1_std\":\"邮\"}]}";
        List<String> list = getList(s, "aftertype1", "lesion_std");
        //Map map = getFieldValues(s, "afterType1");
        String s1 = getConcatOne(s, "afterType1", "type_std");
        Optional<String> optionalS = getOne(s, "afterType1", "type_std");
        optionalS.ifPresent(System.out::println);
        System.out.println();
    }

    /**
     * 解析json中的标化字段，返回指定标化字段的values list
     * @param text
     * @param arrayField
     * @param stdField
     * @return
     */
    public static List<String> getList(String text, String arrayField, String stdField){
        JSONObject root = JSONObject.parseObject(text);
        JSONArray jsonArray = findJSONArray(root, arrayField);
        if (jsonArray==null){
            return new ArrayList<>();
        }
        return findStdFieldValue(jsonArray, stdField);
    }

    /**
     * 解析json中的标化字段，返回指定标化字段的单个value
     * @param text
     * @param arrayField
     * @param stdField
     * @return
     */
    public static Optional<String> getOne(String text, String arrayField, String stdField){
        List<String> list = getList(text, arrayField, stdField);
        return Optional.ofNullable(list.size() != 0 ? list.get(0) : null);
    }

    /**
     * 解析json中的标化字段到一个字符串(无重复值)
     * @param text
     * @param arrayField
     * @param stdField
     * @return 返回指定标化字段拼装后的的values string，比如 "value1,value2,value3"
     */
    public static String getConcatOne(String text, String arrayField, String stdField){
        JSONObject root = JSONObject.parseObject(text);
        JSONArray jsonArray = findJSONArray(root, arrayField);
        if (jsonArray==null){
            return "";
        }
        return processValuesToString(findStdFieldValue(jsonArray, stdField), DUPLICATED_VALUE_FALSE);
    }

    /**
     * 解析json中的标化字段到一个字符串(有重复值)
     * @param text
     * @param arrayField
     * @param stdField
     * @return 返回指定标化字段拼装后的的values string，比如 "value1,value2,value3,value2"
     */
    public static String getDuplicatedConcatOne(String text, String arrayField, String stdField){
        JSONObject root = JSONObject.parseObject(text);
        JSONArray jsonArray = findJSONArray(root, arrayField);
        if (jsonArray==null){
            return "";
        }
        return processValuesToString(findStdFieldValue(jsonArray, stdField),DUPLICATED_VALUE_TRUE);
    }



    /**
     * 处理标化字段list转为字符串
     * @param strings
     * @return
     */
    private static String processValuesToString(List<String> strings,int duplicated){
        String result;
        if (duplicated==DUPLICATED_VALUE_TRUE){
            Set<String> set = new HashSet<>(strings);
            result = set.stream().reduce("", (a, b) -> a + b + ",");
        }else {
            result = strings.stream().reduce("", (a, b) -> a + b + ",");
        }
        if (result.endsWith(",")){
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }


    private static JSONArray findJSONArray(JSONObject jsonObject,String arrayField){
        for (Map.Entry<String,Object> entry:jsonObject.entrySet()
        ) {
            if (arrayField.equals(entry.getKey())){
                return ((JSONArray) entry.getValue());
            }
        }
        return null;
    }

    private static List<String> findStdFieldValue(JSONArray jsonArray, String stdField){
        List<String> result = new ArrayList<>();
        Map<String, List<String>> processMap = new HashMap<>(16);
        for (Object object:jsonArray
        ) {
            JSONObject jsonObject = ((JSONObject) object);
            List<String> list = processMap.get(stdField);
            if (list==null){
                list = new ArrayList<>();
            }
            List<String> finalList = list;
            jsonObject.forEach((key, value) -> {
                if (stdField.equals(key.replaceAll("\\d+", ""))) {
                    finalList.add(String.valueOf(value));
                    processMap.put(key.replaceAll("\\d+", ""), finalList);
                }
            });
        }
        processMap.forEach((key, value) -> {
            if (key.equals(stdField)) {
                result.addAll(value);
            }
        });
        return result;
    }

    /**
     * 解析json中的标化字段
     * @param text json文本
     * @param arrayField json中的jsonarray字段名
     * @return 返回jsonarray中的各个标化字段Map
     */
    @Deprecated
    public static Map<String,List<String>> getFieldValues(String text, String arrayField){
        JSONObject root = JSONObject.parseObject(text);
        JSONArray jsonArray = findJSONArray(root, arrayField);
        Map<String, List<String>> result = new HashMap<>(16);
        if (jsonArray==null){
            return result;
        }
        List<String> stdFields = findAllStdFields(jsonArray);
        stdFields.forEach(stdField -> result.put(stdField, findStdFieldValue(jsonArray, stdField)));
        return result;
    }

    /**
     * 获取所有标化字段的field
     * @param jsonArray
     * @return
     */
    private static List<String> findAllStdFields(JSONArray jsonArray){
        if (jsonArray.size()==0){
            return new ArrayList<>();
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        return new ArrayList<>(jsonObject.keySet());
    }
}

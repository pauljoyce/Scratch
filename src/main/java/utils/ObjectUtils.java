package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mengchao
 * @Date: 2020/9/3 14:53
 */
public class ObjectUtils {
    private static final String JAVAP = "java.";
    private static final String JAVADATESTR = "java.util.Date";

    /**
     * 获取利用反射java bean转map
     *
     * @param obj
     * @return map
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }

    /**
     * 利用反射map转Java bean
     * @param clazz
     * @param map
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static Object mapToObject(Class<?> clazz,Map<String,Object> map) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method:methods
             ) {
            if (method.getName().contains("set")){
                String field = method.getName().replace("set", "");
                field = field.toLowerCase().charAt(0) + field.substring(1);
                if (map.containsKey(field)){
                    method.invoke(object, map.get(field));
                }
            }
        }
        return object;
    }

    /**
     * 利用递归调用将Object中的值全部进行获取
     *
     * @param timeFormatStr 格式化时间字符串默认<strong>-:</strong>
     * @param obj           对象
     * @param excludeFields 排除的属性
     * @return* @throws IllegalAccessException
     */
    public static Map<String, String> objectToMapString(String timeFormatStr, Object obj, String... excludeFields) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();

        if (excludeFields.length != 0) {
            List<String> list = Arrays.asList(excludeFields);
            objectTransfer(timeFormatStr, obj, map, list);
        } else {
            objectTransfer(timeFormatStr, obj, map, null);
        }
        return map;
    }


    /**
     * 递归调用函数
     *
     * @param obj 对象
     * @param map map* @param excludeFields 对应参数
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, String> objectTransfer(String timeFormatStr, Object obj, Map<String, String> map, List<String> excludeFields) throws IllegalAccessException {
        boolean isExclude = false;
        //默认字符串
        String formatStr = "YYYY-MM-dd HH:mm:ss";
        //设置格式化字符串
        if (timeFormatStr != null && !timeFormatStr.isEmpty()) {
            formatStr = timeFormatStr;
        }
        if (excludeFields != null) {
            isExclude = true;
        }
        Class<?> clazz = obj.getClass();
        //获取值
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = clazz.getSimpleName() + "." + field.getName();
            //判断是不是需要跳过某个属性
            if (isExclude && excludeFields.contains(fieldName)) {
                continue;
            }
            //设置属性可以被访问
            field.setAccessible(true);
            Object value = field.get(obj);
            Class<?> valueClass = value.getClass();
            if (valueClass.isPrimitive()) {
                map.put(fieldName, value.toString());

            } else if (valueClass.getName().contains(JAVAP)) {//判断是不是基本类型
                if (valueClass.getName().equals(JAVADATESTR)) {                      //格式化Date类型                      SimpleDateFormat sdf = new SimpleDateFormat(formatStr);                      Date date = (Date) value;                      String dataStr = sdf.format(date);                      map.put(fieldName, dataStr);                  } else {                      map.put(fieldName, value.toString());                  }             } else {
                    objectTransfer(timeFormatStr, value, map, excludeFields);
                }
            }
        }
        return map;
    }
}

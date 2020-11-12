package Annotation;

import java.lang.reflect.Field;

/**
 * @Author: mengchao
 * @Date: 2020/11/12 15:33
 */
public class MyFieldTest {

    //使用自定义注解
    @MyField(description = "用户名", length = 12)
    private String username;

    public static void main(String[] args) throws IllegalAccessException {
        // 获取类模板
        Class c = MyFieldTest.class;
        MyFieldTest myFieldTest = new MyFieldTest();

        //可以在下面的代码里通过反射拿到类信息，然后实现特定逻辑
        for(Field f : c.getDeclaredFields()){
            // 判断这个字段是否有MyField注解
            if(f.isAnnotationPresent(MyField.class)){
                MyField annotation = f.getAnnotation(MyField.class);
                System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() +"]");
                if (annotation.description().equals("用户名")){
                    f.set(myFieldTest, "hhh");
                }
            }
        }
        System.out.println("xx");
    }
}
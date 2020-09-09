package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import utils.ObjectUtils;

/**
 * @Author: mengchao
 * @Date: 2020/8/28 13:56
 */
public class ReflectTest {
    public static void reflectNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("Reflect.User");
        Object object = clazz.newInstance();
        User user = ((User) object);
        user.setAge(11);
        user.setName("xiao");
        System.out.println("x");
    }

    public static void reflectPrivateField() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("Reflect.User");
        Object object = clazz.newInstance();
        Field field = clazz.getDeclaredField("TAG");
        field.setAccessible(true);
        String tag = ((String) field.get(object));
        System.out.println("x");
    }

    public static void reflectPrivateConstructor() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("Reflect.User");
        //Object object = clazz.newInstance();
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance("hahah");
        User user = ((User) object);
        System.out.println("x");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //reflectNewInstance();
        //reflectPrivateField();
        //reflectPrivateConstructor();

        //Map<String, Object> map = ObjectUtils.objectToMap(new User<>("a", 11));

        Map<String, Object> map = new HashMap<>();
        map.put("name", "cha");
        map.put("age", 11);
        ObjectUtils.mapToObject(User.class, map);
        System.out.println("x");
    }
}

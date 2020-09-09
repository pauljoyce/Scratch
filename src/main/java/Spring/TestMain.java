package Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Spring.bean.TestBean;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 10:59
 */
public class TestMain {
    public static void main(String[] args) {
        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        //获取bean
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();
        System.out.println(tb);

        TestBean tb1 = (TestBean) context.getBean("testBean");
        tb1.sayHello();
        System.out.println(tb1);
    }
}

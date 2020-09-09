package Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import Spring.bean.TestBean;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 10:58
 */
@Configuration
public class TestConfiguration {
    public TestConfiguration() {
        System.out.println("TestConfiguration容器启动初始化。。。");
    }

    // @Bean注解注册bean,同时可以指定初始化和销毁方法
    // @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
    @Bean(initMethod = "start",destroyMethod = "cleanUp")
    @Scope("prototype")
    public TestBean testBean() {
        return new TestBean();
    }
}

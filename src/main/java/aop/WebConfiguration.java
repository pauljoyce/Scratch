package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 18:20
 */
@Configuration
@EnableAspectJAutoProxy
public class WebConfiguration {
    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImp();
    }
}

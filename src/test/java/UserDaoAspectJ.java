import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import Spring.bean.TestObjectVo;
import aop.UserDao;
import aop.WebConfiguration;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 18:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfiguration.class)
public class UserDaoAspectJ {
    @Autowired
    UserDao userDao;
    @Autowired
    TestObjectVo testObjectVo;

    @Test
    public void aspectJTest(){
        userDao.addUser();
    }

    @Test
    public void logAspectTest(){
        userDao.findUser(1);
    }

    @Test
    public void yamlObjectTest(){
        System.out.println(testObjectVo.getTaskName());
    }
}

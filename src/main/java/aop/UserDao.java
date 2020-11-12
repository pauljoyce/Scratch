package aop;

import org.springframework.stereotype.Repository;

import Annotation.MyLog;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 18:05
 */
public interface UserDao {
    int addUser();

    void updateUser();

    void deleteUser();

    /**
     * 注意也要在实现类的方法上加上自定义注解@MyLog，否则不生效
     * @param param
     */
    @MyLog
    void findUser(int param);
}

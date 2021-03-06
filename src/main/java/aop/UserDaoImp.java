package aop;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Annotation.MyLog;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 18:06
 */
@Repository
public class UserDaoImp implements UserDao {
    @Override
    public int addUser() {
        System.out.println("add user ......");
        return 6666;
    }

    @Override
    public void updateUser() {
        System.out.println("update user ......");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user ......");
    }

    @MyLog
    @Override
    public void findUser(int param) {
        System.out.println("find user " + param + "......");
    }
}

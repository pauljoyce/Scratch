package aop;

import org.springframework.stereotype.Repository;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 18:05
 */
public interface UserDao {
    int addUser();

    void updateUser();

    void deleteUser();

    void findUser();
}

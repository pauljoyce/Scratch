package Spring.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: mengchao
 * @Date: 2020/9/9 10:56
 */
@Getter
@Setter
public class TestBean {

    private String username;
    private String url;
    private String password;

    public void sayHello() {
        System.out.println("TestBean sayHello()...");
    }

    public void start() {
        System.out.println("TestBean 初始化。。。");
    }

    public void cleanUp() {
        System.out.println("TestBean 销毁。。。");
    }
}
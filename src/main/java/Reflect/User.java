package Reflect;

/**
 * @Author: mengchao
 * @Date: 2020/8/28 13:55
 */
public class User<TAG> {
    private static final String TAG = "BookTag";
    String name;
    protected int age;

    public User() {
        System.out.println("no param constructor");
    }

    private User(String name){
        this.name = name;
    }

    public User(String name, int age) {
        System.out.println("2 params constructor");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected void print(){
        System.out.println("User");
    }
}

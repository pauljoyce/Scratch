import Annotation.DbType;
import Reflect.User;

/**
 * @Author: mengchao
 * @Date: 2020/8/28 17:23
 */
public class ChildUser extends User {
    private int sex;

    public ChildUser(int sex) {
        this.sex = sex;
    }

    public ChildUser() {
    }

    public static void main(String[] args) {
        ChildUser childUser = new ChildUser();
        int a=childUser.age;
        childUser.print();
    }
}

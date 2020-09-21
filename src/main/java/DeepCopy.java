import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: mengchao
 * @Date: 2020/9/14 22:35
 */
public class DeepCopy {
    public static class User implements Cloneable{
        private int id;
        private String name;

        public User(int id,String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public int hashCode(){
            return Objects.hash(id, name);
        }

        /**
         * 默认实现
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public Object clone() throws CloneNotSupportedException {
            User user = ((User) super.clone());
            user.name = new String(name);
            return user;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Staff staff = new Staff(1);
        User user = new User(1, new String("meng"));
        User userA = new User(1, new String("meng"));
        User user1 = user;
        String s = JSON.toJSONString(user);
        User user2 = JSON.parseObject(s, User.class);

        System.out.println(System.identityHashCode(user));
        System.out.println(System.identityHashCode(userA));
        System.out.println(System.identityHashCode(user.getName()));
        System.out.println(System.identityHashCode(userA.getName()));
        System.out.println(System.identityHashCode(user1));
        System.out.println(System.identityHashCode(user2));
        System.out.println(System.identityHashCode(user2.getName()));

        User user3 = ((User) user.clone());
        System.out.println(System.identityHashCode(user3.getName()));
    }
}

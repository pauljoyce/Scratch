package comparable;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2020/12/1 15:06
 */
public class ComparableTest {
    /**
     * 实现Comparable接口，对对象自定义比较
     * x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。
     */
    static class Obj implements Comparable<Obj>{
        Integer id;
        String name;

        @Override
        public int compareTo(Obj o) {
            return this.id.compareTo(o.id);
        }

        public Obj(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Obj(){

        }
    }

    public static void main(String[] args) {
        Obj obj1 = new Obj(4, "ss");
        Obj obj2 = new Obj(3, "ss");
        Obj obj3 = new Obj(9, "ss");

        List<Obj> list = new ArrayList<Obj>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        Collections.sort(list);
        System.out.println();


    }
}

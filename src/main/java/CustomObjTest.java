import java.util.Objects;

/**
 * @Author: mengchao
 * @Date: 2020/4/25 18:45
 */
public class CustomObjTest {
    public static void main(String[] args) {
        CustomObj obj1 = new CustomObj(1, "qq");
        CustomObj obj2 = new CustomObj(1, "qq");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }

}

class CustomObj{
    private int id;
    private String name;

    public CustomObj(int id, String name) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomObj obj = (CustomObj) o;
        return id == obj.id &&
                Objects.equals(name, obj.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}

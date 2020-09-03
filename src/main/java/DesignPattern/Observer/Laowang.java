package DesignPattern.Observer;

public class Laowang implements Person{
    private String name = "老王";

    public Laowang() {
    }

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到了小美打过来的电话，电话内容是：" + s);
    }
}

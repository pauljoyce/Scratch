package DesignPattern.strategy;

/**
 * @Author: mengchao
 * @Date: 2021/1/12 17:55
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new RedPen());
        context.drawExec(1, 2, 3);
    }
}

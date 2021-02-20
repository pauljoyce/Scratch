package DesignPattern.strategy;

/**
 * @Author: mengchao
 * @Date: 2021/1/12 17:54
 */
public class RedPen implements Strategy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("RedPen draw()");
    }
}

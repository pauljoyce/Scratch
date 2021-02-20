package DesignPattern.strategy;

/**
 * @Author: mengchao
 * @Date: 2021/1/12 17:54
 */
public class BluePen implements Strategy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("BluePen draw()");
    }
}

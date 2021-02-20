package DesignPattern.strategy;

/**
 * @Author: mengchao
 * @Date: 2021/1/12 17:56
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void drawExec(int radius, int x, int y){
        strategy.draw(radius, x, y);
    }

}

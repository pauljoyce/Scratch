package DesignPattern.Observer;

public class Test {
    public static void main(String[] args) {

        XiaoMei xiao_mei = new XiaoMei();
        Laowang lao_wang = new Laowang();
        Laoli lao_li = new Laoli();

        //老王和老李在小美那里都注册了一下
        xiao_mei.addPerson(lao_wang);
        xiao_mei.addPerson(lao_li);

        //小美向老王和老李发送通知
        xiao_mei.notifyPerson();
    }
}

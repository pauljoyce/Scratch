package UEFACL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

//    public Group getResult(){
//
//    }

    public static void main(String[] args) {
        List<Team> pool = new ArrayList<Team>();
        pool.add(new Team("皇家马德里", "西班牙", 1));
        pool.add(new Team("马德里竞技", "西班牙", 1));
        pool.add(new Team("巴塞罗那", "西班牙", 1));
        pool.add(new Team("拜仁慕尼黑", "德国", 1));
        pool.add(new Team("尤文图斯", "意大利", 1));
        pool.add(new Team("巴黎圣日耳曼", "法国", 1));
        pool.add(new Team("曼城", "英格兰", 1));
        pool.add(new Team("莫斯科火车头", "俄罗斯", 1));

        pool.add(new Team("多特蒙德", "德国", 2));
        pool.add(new Team("曼联", "英格兰", 2));
        pool.add(new Team("顿涅茨克矿工", "俄罗斯", 2));
        pool.add(new Team("那不勒斯", "意大利", 2));
        pool.add(new Team("热刺", "英格兰", 2));
        pool.add(new Team("罗马", "意大利", 2));
        pool.add(new Team("本菲卡", "葡萄牙", 2));
        pool.add(new Team("波尔图", "葡萄牙", 2));

        pool.add(new Team("利物浦", "英格兰", 3));
        pool.add(new Team("沙尔克04", "德国", 3));
        pool.add(new Team("里昂", "法国", 3));
        pool.add(new Team("摩纳哥", "法国", 3));
        pool.add(new Team("阿贾克斯", "荷兰", 3));
        pool.add(new Team("莫斯科中央陆军", "俄罗斯", 3));
        pool.add(new Team("瓦伦西亚", "西班牙", 3));
        pool.add(new Team("埃因霍温", "荷兰", 3));

        pool.add(new Team("布鲁日", "比利时", 4));
        pool.add(new Team("加拉塔萨雷", "土耳其", 4));
        pool.add(new Team("伯尔尼年轻人", "瑞士", 4));
        pool.add(new Team("国际米兰", "意大利", 4));
        pool.add(new Team("霍芬海姆", "德国", 4));
        pool.add(new Team("雅典AEK", "希腊", 4));
        pool.add(new Team("贝尔格莱德红星", "塞尔维亚", 4));
        pool.add(new Team("比尔森胜利", "捷克", 4));


        List<Group> groups = new ArrayList<>();

        Group groupA = new Group("A");
        Group groupB = new Group("B");
        Group groupC = new Group("C");
        Group groupD = new Group("D");
        Group groupE = new Group("E");
        Group groupF = new Group("F");
        Group groupG = new Group("G");
        Group groupH = new Group("H");

        groups.add(groupA);
        groups.add(groupB);
        groups.add(groupC);
        groups.add(groupD);
        groups.add(groupE);
        groups.add(groupF);
        groups.add(groupG);
        groups.add(groupH);

        int i = 8;
        while (i>0){
            Random random = new Random(1);
            Random random2 = new Random(20);

            int teamIndex = random2.nextInt(8);
            Team team=pool.get(teamIndex);
            pool.remove(teamIndex);

            Group group=groups.get(random.nextInt(8));
            List list = new ArrayList<>();
            list.add(team);
            group.setTeams(list);
        }


        System.out.println(groups.toString());

    }
}

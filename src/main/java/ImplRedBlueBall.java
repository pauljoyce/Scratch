import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImplRedBlueBall implements RedBlueBall {
    @Override
    public List<Integer> getNumber() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i=0;i<6;i++){
            list.add(random.nextInt(33)+1);
        }
        list.add(random.nextInt(16) + 1);
        return list;
    }
}

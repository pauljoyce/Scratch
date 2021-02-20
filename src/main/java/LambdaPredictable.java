import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2021/1/14 11:46
 * 挑苹果中的行为参数化思想
 * https://chaycao.github.io/2020/05/17/%E6%8C%91%E8%8B%B9%E6%9E%9C%E4%B8%AD%E7%9A%84%E8%A1%8C%E4%B8%BA%E5%8F%82%E6%95%B0%E5%8C%96%E6%80%9D%E6%83%B3/
 *
 */
public class LambdaPredictable {
    public interface StandardPredicate<T>{
        public boolean isMeetStandard(T object);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<String> result=filter(strings, (string) -> {
            if (string.endsWith("good")) {
                return true;
            }
            return false;
        });
    }

    public static <T> List<T> filter(List<T> objects,StandardPredicate<T> predicate){
        List<T> results = new ArrayList<>();
        for (T t:objects
             ) {
            if (predicate.isMeetStandard(t)) {
                results.add(t);
            }
        }
        return results;
    }
}

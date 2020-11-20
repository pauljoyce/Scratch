import java.math.BigDecimal;

/**
 * @Author: mengchao
 * @Date: 2020/11/19 10:20
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = BigDecimal.valueOf(10.01);
        bigDecimal1 = bigDecimal1.divide(new BigDecimal(5.08),BigDecimal.ROUND_DOWN);
        //bigDecimal1 = bigDecimal1.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1);
    }
}

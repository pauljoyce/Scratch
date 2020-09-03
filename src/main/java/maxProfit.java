
public class maxProfit {
    public int maxProfit(int[] prices) {
        int gap = 0;
        for (int i=prices.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                int a = prices[i] - prices[j];
                if (a>gap){
                        gap = a;
                }
            }
        }
        return gap;
    }

    public static void main(String[] args) {
        maxProfit maxProfit = new maxProfit();
        int[] x = {5,0,2,0};
        System.out.println(maxProfit.maxProfit(x));
    }
}

package BestTimetoBuyandSellStock;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxpro=0;
        int minprice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minprice=Math.min(minprice,prices[i]);
            maxpro=Math.max(maxpro,prices[i]-minprice);
        }
        return maxpro;
    }
}

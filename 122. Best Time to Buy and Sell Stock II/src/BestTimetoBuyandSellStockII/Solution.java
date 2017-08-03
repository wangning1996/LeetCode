package BestTimetoBuyandSellStockII;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //从头到尾扫描prices，如果price[i] – price[i-1]大于零则计入最后的收益中。即贪心法
        int maxpro=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0)
                maxpro+=prices[i]-prices[i-1];
        }
        return maxpro;
    }
}

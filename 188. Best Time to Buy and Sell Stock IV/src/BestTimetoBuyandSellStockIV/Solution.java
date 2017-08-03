package BestTimetoBuyandSellStockIV;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wangning on 2017/8/3.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0) return 0;
        if(k>=prices.length) return maxprofit(prices);
        int[] buy = new int[k+1];
        Arrays.fill(buy,Integer.MIN_VALUE);
        int[] sell = new int[k+1];
        Arrays.fill(sell,0);
        int maxpro=0;
        for(int i=0;i<prices.length;i++){
            //第K次卖完剩余的前是前面i-1天卖完第K次剩余的钱和今天卖之后的钱的比较
            for(int j=k;j>=1;j--){
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
                buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
            }
            maxpro=Math.max(maxpro,sell[k]);
        }
        return maxpro;
    }
    private int maxprofit(int[] prices) {
        //从头到尾扫描prices，如果price[i] – price[i-1]大于零则计入最后的收益中。即贪心法
        int maxpro=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0)
                maxpro+=prices[i]-prices[i-1];
        }
        return maxpro;
    }
}

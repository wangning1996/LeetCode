package BestTimetoBuyandSellStockIII;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        /*Thank for the discuss
        Buy1[i]表示前i天做第一笔交易买入股票后剩下的最多的钱；
        Sell1[i]表示前i天做第一笔交易卖出股票后剩下的最多的钱；
        Buy2[i]表示前i天做第二笔交易买入股票后剩下的最多的钱；
        Sell2[i]表示前i天做第二笔交易卖出股票后剩下的最多的钱；
        */
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for(int i=0;i<prices.length;i++){
            //第二次卖完剩余的前是前面i-1天卖完第二次剩余的钱和今天卖之后的钱的比较
            sell2 = Math.max(sell2,buy2+prices[i]);
            //
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell1 = Math.max(sell1,buy1+prices[i]);
            buy1 = Math.max(buy1,0-prices[i]);

        }

        return sell2;
    }
}

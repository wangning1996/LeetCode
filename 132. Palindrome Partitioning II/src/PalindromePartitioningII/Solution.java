package PalindromePartitioningII;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int minCut(String s) {
        //dp中i，j代表从i到j的串是否是回文串，是的话写1，不是写0
        int [][] dp=new int[s.length()][s.length()];
        //cut中i代表从第i个地方切开的局部最优的切的次数
        int [] cut=new int[s.length()+1];

        //分为前后两部分，i代表在第i个元素处分为前后两段
        for(int i=s.length()-1;i>=0;i--)
        {
            cut[i]=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++)
            {
                //从i至j之间的字符串为回文串
                //判断条件为：
                //如果两个元素相等，代表头和尾是相同元素，此时如果头和尾同时指向元素A，或者头和尾之间没有元素，如AA时说明从i到j为回文串
                //或者是头和尾相同时，如果从i的后一个，j的前一个形成的串是回文串的话，那么当前的串也是回文串
                if(s.charAt(i)==s.charAt(j)&&(j-i<=1||dp[i+1][j-1]==1))
                {
                    dp[i][j]=1;
                    //当前从i到j是回文串时，判断当前从i到length-1处的串如果要在i处切开所需要的最小次数，
                    //也就是当前最小次数和要切开从j+1到length-1处的串的次数+1的最小值，次数+1是因为从i到j也算了一次
                    cut[i]=Math.min(1+cut[j+1],cut[i]);
                }
            }
        }
        return cut[0]-1;
    }
}

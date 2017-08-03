package Triangle;

import java.util.List;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 对于一个data[i][j]，和它相邻的数字就是data[i+1][j]和data[i+1][j+1]。
         *
         * 用minimus[i][j]来表示从第i行第j列处的数字开始往下到最后一层的最小路径和，那么有
         *
         * minimus[i][j]=data[i][j]+min(minimums[i+1][j]+minimums[i+1][j+1])
         *
         * 从最后一行开始往上（row），从左向右（col）循环计算并更新minNums的值
         *
         * minNums[col]=min(minNums[col], minNums[col+1]) + triangle[row][col]
         */
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }

        return A[0];
    }
}

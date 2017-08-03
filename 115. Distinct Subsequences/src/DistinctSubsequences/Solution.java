package DistinctSubsequences;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int m =s.length();
        int n=t.length();
        int[][] arr = new int[m+1][n+1];
        arr[0][0]=1;
        for(int i=0;i<=m;i++){
            arr[i][0]=1;
        }
        for(int j=1;j<=n;j++){
            arr[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    //如果相等可以删除，可以不删除
                    //可以删除时看上边
                    //不删除看对角
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
                else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[m][n];
    }
}

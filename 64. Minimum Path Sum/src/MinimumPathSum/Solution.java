package MinimumPathSum;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        if(n==0) return 0;
        int minsum=Integer.MAX_VALUE;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    arr[i][j]=grid[i][j];
                }
                else if(i==0&&j!=0){
                    arr[i][j]=arr[i][j-1]+grid[i][j];
                }
                else if(i!=0&&j==0){
                    arr[i][j]=arr[i-1][j]+grid[i][j];
                }
                else{
                    arr[i][j]=Math.min(arr[i-1][j],arr[i][j-1])+grid[i][j];
                }
            }
        }
        return arr[m-1][n-1];
    }
}

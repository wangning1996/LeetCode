package UniquePathsII;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        if(m==0) return 0;
        int n=obstacleGrid[0].length;
        if(n==0) return 0;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                arr[i][0]=1;
            }
            else
                break;
        }
        for(int j = 0;j<n;j++){
            if(obstacleGrid[0][j]!=1){
                arr[0][j]=1;
            }
            else
                break;
        }
        for(int i=1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j]!=1) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }
        return arr[m-1][n-1];
    }
}

package DungeonGame;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    /**
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {

       int m = dungeon.length;
       if(m==0) return 0;
       int n = dungeon[0].length;
       int[][] arr = new int[m+1][n+1];
       for(int i=m-1;i>=0;i--){
           for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1){
                    arr[i][j]=Math.max(1,1-arr[i][j]-dungeon[i][j]);
                }
                else if(i==m-1){
                    arr[i][j]=Math.max(1,arr[i][j+1]-dungeon[i][j]);
                }
                else if(j==n-1){
                    arr[i][j]=Math.max(1,arr[i+1][j]-dungeon[i][j]);
                }
                else{
                    arr[i][j]=Math.max(1,Math.min(arr[i+1][j],arr[i][j+1])-dungeon[i][j]);
                }
           }
       }
       return arr[0][0];
    }
}

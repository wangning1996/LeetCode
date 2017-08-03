package EditDistance;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m==0) return n;
        if(n==0) return m;
        /**
         *                        ----    D(i-1, j) + 1
         D(i,j)=          min     ----    D(i, j-1) + 1)
                                  ----    D(i-1, j-1) +1( if  X(i) != Y(j) ) ; D(i-1,j-1) ( if  X(i) == Y(j) )
         */
        int[][] arr = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
            arr[i][0]=i;
        for(int i=1;i<=n;i++)
            arr[0][i]=i;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i+1][j+1]=Math.min(arr[i+1][j]+1,arr[i][j+1]+1);
                if(word1.charAt(i)==word2.charAt(j)){
                    arr[i+1][j+1]=Math.min(arr[i+1][j+1],arr[i][j]);
                }
                else{
                    arr[i+1][j+1]=Math.min(arr[i+1][j+1],arr[i][j]+1);
                }
            }
        }
        for(int i=0;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("INTENTION","EXECUTION"));
    }
}

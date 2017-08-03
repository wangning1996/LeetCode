package SetMatrixZeroes;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        if(n==0) return;;
        boolean frow = false;
        boolean fcol = false;
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
               frow=true;
               break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                fcol=true;
                break;
            }
        }
        //将第一行和第一列0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(frow==true){
            for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
        if(fcol==true) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
     }
}

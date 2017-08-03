package RotateImage;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        dfs(matrix,0,matrix.length-1);
    }
    public static void dfs(int[][] matrix,int firstrow,int lastrow){
        if(firstrow>=lastrow) return;
        else{
            //最后一列不能重复旋转
            for(int i=firstrow;i<lastrow;i++){
                swap(matrix,i,firstrow,lastrow);
            }
            dfs(matrix,firstrow+1,lastrow-1);
        }
    }
    public static void swap(int[][] matrix,int i,int firstrow,int lastrow){
        int temp=matrix[firstrow][i];
        matrix[firstrow][i]=matrix[matrix.length-1-i][firstrow];
        matrix[matrix.length-1-i][firstrow]=matrix[lastrow][matrix.length-1-i];
        matrix[lastrow][matrix.length-1-i]=matrix[i][lastrow];
        matrix[i][lastrow]=temp;
    }

    public static void main(String[] args) {
        int[][] a={
                {1,2,3,4,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}
        };
        Solution s = new Solution();
        s.rotate(a);
        for(int i=0;i<a.length;i++){
            for (int j=0;j<a.length;j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }
}

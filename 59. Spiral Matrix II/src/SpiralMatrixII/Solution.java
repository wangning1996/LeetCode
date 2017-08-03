package SpiralMatrixII;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        if(matrix.length==0) return matrix;
        read(0,matrix,0,matrix.length-1,0,matrix[0].length-1);
        return matrix;
    }
    public static void read(int flg,int[][] matrix ,int firstrow ,int lastrow,int firstcol,int lastcol){
        if(firstrow>lastrow)
            return;
        else if(firstrow==lastrow) {
            matrix[firstcol][lastcol]=++flg;
            return;
        }
        else {
            for (int i = firstcol; i < lastcol; i++)
                matrix[firstrow][i] = ++flg;
            for (int i = firstrow; i < lastrow; i++)
                matrix[i][lastcol] = ++flg;
            for (int i = lastcol; i > firstcol; i--)
                matrix[lastrow][i] = ++flg;
            for (int i = lastrow; i > firstrow; i--)
                matrix[i][firstcol] = ++flg;
            read(flg, matrix, firstrow + 1, lastrow - 1, firstcol + 1, lastcol - 1);

        }
    }

    public static void main(String[] args) {
        int a[][] =new Solution().generateMatrix(5);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

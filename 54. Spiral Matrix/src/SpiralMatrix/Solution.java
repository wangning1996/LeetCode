package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0) return list;
        //行数小于等于列数为真
        boolean flg=true;
        if(matrix.length>matrix[0].length)
            flg=false;
        read(list,matrix,0,matrix.length-1,0,matrix[0].length-1,flg);
        return list;
    }
    public static void read(List<Integer> list,int[][] matrix ,int firstrow ,int lastrow,int firstcol,int lastcol,boolean flg){
        if(flg&&firstrow>lastrow)
            return;
        if(!flg&&firstcol>lastcol)
            return;
        if(flg&&firstrow==lastrow) {
            for(int i=firstcol;i<=lastcol;i++)
                list.add(matrix[firstrow][i]);
            return;
        }
        if(!flg&&firstcol==lastcol) {
            for(int i=firstrow;i<=lastrow;i++)
                list.add(matrix[i][firstcol]);
            return;
        }
        System.out.println("fr"+firstrow);
        System.out.println("lr"+lastrow);
        System.out.println("fc"+firstcol);
        System.out.println("lc"+lastcol);
            for(int i=firstcol;i<lastcol;i++)
                list.add(matrix[firstrow][i]);
            for(int i=firstrow;i<lastrow;i++)
                list.add(matrix[i][lastcol]);
            for(int i=lastcol;i>firstcol;i--)
                list.add(matrix[lastrow][i]);
            for(int i=lastrow;i>firstrow;i--)
                list.add(matrix[i][firstcol]);
            read(list,matrix,firstrow+1,lastrow-1,firstcol+1,lastcol-1,flg);


    }

    public static void main(String[] args) {
        int a[][]={
                {1,2},{3,4},{5,6},{7,8},{9,10}
        };
        System.out.println(new Solution().spiralOrder(a));
    }
}

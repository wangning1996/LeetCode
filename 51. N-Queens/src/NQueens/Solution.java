package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        char[][] a =new char[n][n];
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = '.';
            }
        }
        dfs(lists,a,0,n);
        return lists;
    }
    public static void dfs(List<List<String>> lists,char[][] chess,int row,int n){
        if(row==n){
            List<String> ins = new ArrayList<>();
            for(int j=0;j<n;j++) {
                ins.add(new String(chess[j]));
            }
            lists.add(ins);
            return;
        }
        else {
            //从第一列到最后一列看是否能插入
            for (int i = 0; i < n; i++) {
                //如果是有效插入
                chess[row][i] = 'Q';
                if (isvalid(chess, row, i)) {
                    dfs(lists, chess, row + 1, n);
                }
                chess[row][i] = '.';
            }
        }
    }
    public static boolean isvalid(char[][] chess,int row,int i){
        //检测斜对角线上是否有Q
        int temprow=row;
        for(int k=i;k>=0;k--){
            if(temprow>=0){
                if(chess[temprow][k]=='Q'&&k!=i&&temprow!=row){
                    return false;
                }
            }
            temprow--;

        }
        temprow=row;
        for(int k=i;k<chess.length;k++){
            if(temprow>=0){
                if(chess[temprow][k]=='Q'&&k!=i&&temprow!=row){
                    return false;
                }

            }
            temprow--;

        }
        for(int k=row;k>=0;k--){
            if(chess[k][i]=='Q'&&row!=k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(5));
    }
}

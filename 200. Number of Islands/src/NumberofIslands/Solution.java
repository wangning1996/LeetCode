package NumberofIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangning on 2017/8/3.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    ranse(i,j,grid);
                    max++;
                }
            }
        }
        return max;
    }
    private void ranse(int x,int y,char[][] grid){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;
        grid[x][y]=0;
        ranse(x-1,y,grid);
        ranse(x+1,y,grid);
        ranse(x,y-1,grid);
        ranse(x,y+1,grid);
    }
    public static void main(String[] args) {
        /*System.out.println(new Solution().numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
        */
        System.out.println(new Solution().numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        }));
    }
}

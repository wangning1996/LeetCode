package SudokuSolver;

import java.util.HashSet;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if(issuccess(board)==true)
            return;
    }
    public boolean issuccess(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') {
                    for(char k='1';k<='9';k++){
                        board[i][j]=k;
                        if(isvalid(board,i,j)&&issuccess(board))
                            return true;
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isvalid(char[][] board,int x,int y){
        for(int j=0;j<9;j++){
            if(board[x][j]==board[x][y]&&j!=y)
                return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][y]==board[x][y]&&i!=x)
                return false;
        }
        int blockrow=x/3;
        int blockcol=y/3;
        for(int i=blockrow*3;i<blockrow*3+3;i++){
            for(int j=blockcol*3;j<blockcol*3+3;j++){
                if(board[i][j]==board[x][y]&&i!=x&&j!=y)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][]={
                //1   2    3   4   5   6    7   8   9
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'},
                };

        Solution s =new Solution();
        s.solveSudoku(board);
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}

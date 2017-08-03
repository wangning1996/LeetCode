package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> s = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    //记录下行号+列号+块号
                    if(!s.add("row"+i+"num"+board[i][j])||!s.add("col"+j+"num"+board[i][j])||!s.add("block"+i/3+j/3+board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

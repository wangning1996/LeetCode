package WordSearch;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] arr = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0,arr)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word,int i,int j,int count,boolean[][] arr){
        if(count==word.length()-1)
            return true;
        arr[i][j]=true;
        if(i-1>=0&&arr[i-1][j]==false&&board[i-1][j]==word.charAt(count+1)&&dfs(board,word,i-1,j,count+1,arr))
            return true;
        if(i+1<board.length&&arr[i+1][j]==false&&board[i+1][j]==word.charAt(count+1)&&dfs(board,word,i+1,j,count+1,arr))
            return true;
        if(j-1>=0&&arr[i][j-1]==false&&board[i][j-1]==word.charAt(count+1)&&dfs(board,word,i,j-1,count+1,arr))
            return true;
        if(j+1<board[0].length&&arr[i][j+1]==false&&board[i][j+1]==word.charAt(count+1)&&dfs(board,word,i,j+1,count+1,arr))
            return true;
        arr[i][j]=false;
        return false;
    }
}

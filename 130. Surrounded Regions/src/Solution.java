import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    class Node{
        int row;
        int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        Queue<Node> queue = new LinkedList<>();
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        int[][] arr = new int[m][n];//代表这个点是否被访问过了
        //将第一行，第一列，最后一行，最后一列是O的点放入队列
        //每次从队列中取出，只要它的上下左右对应位置有O并且还没有被访问过的点加入队列
        //最后队列中所有元素都走完，剩下的没被访问过得点肯定是被包起来的，会变成x
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                queue.add(new Node(i,0));
            if(board[i][n-1]=='O')
                queue.add(new Node(i,n-1));
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                queue.add(new Node(0,j));
            if(board[m-1][j]=='O')
                queue.add(new Node(m-1,j));
        }
        while (!queue.isEmpty()){
            Node now = queue.peek();
            queue.poll();
            if(arr[now.row][now.col]==1)
                continue;
            arr[now.row][now.col]=1;
            //上
            if(now.row>0&&arr[now.row-1][now.col]==0&&board[now.row-1][now.col]=='O')
                queue.add(new Node(now.row-1,now.col));
            //下
            if(now.row<m-1&&arr[now.row+1][now.col]==0&&board[now.row+1][now.col]=='O')
                queue.add(new Node(now.row+1,now.col));
            //左
            if(now.col>0&&arr[now.row][now.col-1]==0&&board[now.row][now.col-1]=='O')
                queue.add(new Node(now.row,now.col-1));
            //右
            if(now.col<n-1&&arr[now.row][now.col+1]==0&&board[now.row][now.col+1]=='O')
                queue.add(new Node(now.row,now.col+1));
        }
        for(int row=0;row<m;row++){
            for(int col = 0;col<n;col++){
                if(arr[row][col]==0)
                    board[row][col]='X';
            }
        }
    }
}

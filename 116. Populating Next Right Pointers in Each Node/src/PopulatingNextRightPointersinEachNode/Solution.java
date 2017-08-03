package PopulatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return ;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int t=q.size();
            for(int i=0;i<t;i++){
                TreeLinkNode temp= q.peek();
                q.poll();
                if(i==t-1){
                    temp.next=null;
                }
                else{
                    temp.next=q.peek();
                }
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }

        }
    }
}

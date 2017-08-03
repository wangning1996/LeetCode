package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangning on 2017/8/3.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int t=q.size();
            for(int i=0;i<t;i++){
                TreeNode temp= q.peek();
                if(i==t-1)
                    list.add(temp.val);
                q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return list;
    }
}

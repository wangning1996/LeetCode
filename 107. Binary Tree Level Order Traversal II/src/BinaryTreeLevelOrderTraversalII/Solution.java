package BinaryTreeLevelOrderTraversalII;

import java.util.*;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ins =new ArrayList<>();
            int t=q.size();
            for(int i=0;i<t;i++){
                TreeNode temp= q.peek();
                ins.add(temp.val);
                q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            stack.push(ins);
        }
        while(!stack.isEmpty()){
            list.add(stack.peek());
            stack.pop();
        }
        return list;
    }
}

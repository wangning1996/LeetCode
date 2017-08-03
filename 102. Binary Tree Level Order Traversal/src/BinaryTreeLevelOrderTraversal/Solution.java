package BinaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height=0;
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
            list.add(ins);

        }
        return list;
    }
}

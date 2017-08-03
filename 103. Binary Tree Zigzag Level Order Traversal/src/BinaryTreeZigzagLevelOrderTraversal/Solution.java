package BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        list.add(list1);
        q.add(root);
        int height=1;
        while(!q.isEmpty()){
            List<Integer> ins =new ArrayList<>();
            int t=q.size();
            List<TreeNode> te =new ArrayList<>();
            for(int i=0;i<t;i++){
                TreeNode temp= q.peek();
                te.add(temp);
                q.poll();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            if(height%2==0){//l-r
                for(TreeNode node:te){
                    if(node.left!=null)
                        ins.add(node.left.val);
                    if(node.right!=null)
                        ins.add(node.right.val);
                }
                height++;
            }
            else{
                for(int i=te.size()-1;i>=0;i--){
                    if(te.get(i).right!=null)
                        ins.add(te.get(i).right.val);
                    if(te.get(i).left!=null)
                        ins.add(te.get(i).left.val);
                }
                height++;
            }
            if(ins.size()>0)
                list.add(ins);

        }
        return list;
    }
}

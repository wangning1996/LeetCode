package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/31.
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(root.left!=null) inorder(root.left,list);
        if(root.right!=null) inorder(root.right,list);
    }
}

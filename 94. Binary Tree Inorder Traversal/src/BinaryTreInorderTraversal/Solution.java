package BinaryTreInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left!=null) inorder(root.left,list);
        list.add(root.val);
        if(root.right!=null) inorder(root.right,list);
    }
}

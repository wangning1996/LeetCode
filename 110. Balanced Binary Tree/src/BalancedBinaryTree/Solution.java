package BalancedBinaryTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.abs(left-right)<=1&&isBalanced(root.left) && isBalanced(root.right);
    }
    private int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

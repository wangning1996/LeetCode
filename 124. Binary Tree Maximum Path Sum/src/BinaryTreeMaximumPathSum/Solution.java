package BinaryTreeMaximumPathSum;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    int maxvalue;
    public int maxPathSum(TreeNode root) {
        maxvalue = Integer.MIN_VALUE;
        maxsum(root);
        return maxvalue;
    }
    public int maxsum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,maxsum(root.left));
        int right = Math.max(0,maxsum(root.right));
        //记录下最大值
        maxvalue=Math.max(left+right+root.val,maxvalue);
        //返回给上一层左子树或者右子树的最大值表示当前根所能提供的最大值
        return Math.max(left,right)+root.val;
    }
}

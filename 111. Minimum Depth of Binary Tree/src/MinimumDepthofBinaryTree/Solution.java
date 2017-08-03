package MinimumDepthofBinaryTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int l=minDepth(root.left);
        int r=minDepth(root.right);
        return Math.min(l,r)>0?1+Math.min(l,r):1+Math.max(l,r);
    }
}

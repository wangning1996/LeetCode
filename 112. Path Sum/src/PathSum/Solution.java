package PathSum;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.right==null&&root.left==null&&root.val==sum)
            return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}

package SymmetricTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root,root);
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null&&p==null) return true;
        if(q==null||p==null) return false;
        if(q.val==p.val)
            return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
        return false;
    }
}

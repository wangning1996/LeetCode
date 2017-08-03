package isSameTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null&&p==null) return true;
        if(q==null||p==null) return false;
        if(q.val==p.val)
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        return false;
    }
}

package RecoverBinarySearchTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    TreeNode f1=null;
    TreeNode f2=null;
    TreeNode f3 = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=f1.val;
        f1.val=f2.val;
        f2.val=temp;

    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(f1==null&&f3.val>=root.val){f1=f3;}
        if(f1!=null&&f3.val>=root.val){f2=root;}
        f3=root;
        inorder(root.right);
    }
}

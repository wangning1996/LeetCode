package SumRoottoLeafNumbers;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {

        return sum(root,0);
    }
    private int sum(TreeNode root,int rest){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return rest*10+root.val;
        return sum(root.left,rest*10+root.val)+sum(root.right,rest*10+root.val);
    }
}

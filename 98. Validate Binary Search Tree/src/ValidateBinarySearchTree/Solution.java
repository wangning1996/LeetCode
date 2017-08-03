package ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1))
                return false;
        }
        return true;
    }
    public static void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left!=null) inorder(root.left,list);
        list.add(root.val);
        if(root.right!=null) inorder(root.right,list);
    }
}

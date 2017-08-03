package ConstructBinaryTreefromPreorderandInorderTraversal;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1,0);
    }
    private TreeNode build(int[] preorder, int[] inorder,int start,int end,int count){
        //count记录先序序列中根的位置
        if(count>preorder.length-1||start>end) return null;
        TreeNode root = new TreeNode(preorder[count]);
        int index = findindex(root.val,inorder,start,end);
        root.left=build(preorder,inorder,start,index-1,count+1);
        //先序中跳过左子树的长度就是右子树的根
        root.right=build(preorder,inorder,index+1,end,count+1+index-start);
        return root;
    }
    private int findindex(int a,int[] b,int st,int sd){
        for(int i=st;i<=sd;i++){
            if(a==b[i])
                return i;
        }
        return -1;
    }
}

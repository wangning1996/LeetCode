package ConstructBinaryTreefromInorderandPostorderTraversal;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,inorder,0,postorder.length-1,postorder.length-1);
    }
    private TreeNode build(int[] postorder, int[] inorder,int start,int end,int count){
        if(count<0||start>end) return null;
        TreeNode root = new TreeNode(postorder[count]);
        int index = findindex(root.val,inorder);
        root.left=build(postorder,inorder,start,index-1,count-1-end+index);
        root.right=build(postorder,inorder,index+1,end,count-1);
        return root;
    }
    private int findindex(int a,int[] b){
        for(int i=0;i<b.length;i++){
            if(a==b[i])
                return i;
        }
        return -1;
    }
}

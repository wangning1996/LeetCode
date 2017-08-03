package FlattenBinaryTreetoLinkedList;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                //每次都将左子树的所有右结点全部转移过去，斜着转移
                TreeNode p =root.left;
                while(p.right!=null){
                    p=p.right;
                }
                //此时p指向左孩子的最右结点

                //最右结点指向root的右子树就转移过去了
                p.right = root.right;
                //此时让root结点的右指针指向前面记录的它的左孩子
                root.right=root.left;
                //此时它的左孩子已经为空，右孩子已经成了p的孩子,虽然它的左孩子已经没有实际意义了，但是还要进行断开，否则树结构不会改变
                root.left=null;
            }

            //此时的root转移到了他的右孩子上，从最初树结构来说是左孩子
            root=root.right;
        }
    }
}

package UniqueBinarySearchTreesII;

import sun.reflect.generics.tree.Tree;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    /**
     * 采取的是自底向上的求解过程。
     1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
     2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
     3. 最后，把根结点放入链表中。
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return help(1,n);
    }
    public static List<TreeNode> help(int s,int e){
        List<TreeNode> list = new ArrayList<>();
        if(s>e){
            list.add(null);
            return list;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> leftchild = help(s,i-1);
            List<TreeNode> rightchid = help(i+1,e);
            for(TreeNode left: leftchild){
                for(TreeNode right:rightchid){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

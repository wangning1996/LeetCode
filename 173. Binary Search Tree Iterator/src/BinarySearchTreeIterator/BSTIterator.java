package BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Created by wangning on 2017/8/2.
 */
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class BSTIterator {

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode t =root;
        while(t!=null){
            stack.push(t);
            t=t.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode t =stack.pop();
        TreeNode s = t;
        if(t.right!=null){
            t=t.right;
            while(t!=null){
                stack.push(t);
                t=t.left;
            }
        }
        return s.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

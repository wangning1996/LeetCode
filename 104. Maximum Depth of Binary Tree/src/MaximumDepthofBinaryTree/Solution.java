package MaximumDepthofBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

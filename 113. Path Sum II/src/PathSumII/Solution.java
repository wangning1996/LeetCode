package PathSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        help(list,root,sum,new ArrayList<>());
        return list;
    }
    private void help(List<List<Integer>> list,TreeNode root, int sum,List<Integer> l2){
        if(root==null)
            return ;
        if(root.right==null&&root.left==null&&root.val==sum){
            List<Integer> l =new ArrayList<>(l2);
            l.add(root.val);
            list.add(l);
            return ;
        }
        l2.add(root.val);
        int size = l2.size();
        help(list,root.left,sum-root.val,l2);
        help(list,root.right,sum-root.val,l2);
        l2.remove(size-1);
    }
}

package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l1=new ArrayList<>();
        if(n<1||n<k) return l1;
        List<Integer> l2 =new ArrayList<>();
        helper(l1,l2,n,k,1);
        return l1;
    }
    public static void helper(List<List<Integer>> l1,List<Integer> l2 ,int n, int k,int start){
        if(l2.size()==k){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=start;i<=n;i++){
            l2.add(i);
            if(l2.size()<=k)
                helper(l1,l2,n,k,i+1);
            l2.remove(l2.size()-1);
        }

    }
}

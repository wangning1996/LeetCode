package CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),k,n,1);
        return list;
    }
    private void helper(List<List<Integer>> list, List<Integer> l2, int k, int n, int start){
        if(n==0){
            if(k==0){
                list.add(new ArrayList<>(l2));
                return;
            }
            else
                return;
        }
        else if(n<0){
            return;
        }
        else{
            if(k==0) return;
            for(int i=start;i<=9;i++){
                if(l2.contains(i))
                    continue;
                else{
                    l2.add(i);
                    helper(list,l2,k-1,n-i,i+1);
                    l2.remove(l2.size()-1);
                }
            }
        }
    }
}

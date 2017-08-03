package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        issuccess(list,new ArrayList<Integer>(),0,candidates,target,0);
        return list;
    }
    public static void issuccess(List<List<Integer>> l1,List<Integer> l2,int sum,int[] candidates, int target,int start){
        if(sum>target){
            return;
        }
        else if(sum==target) {
            l1.add(new ArrayList<>(l2));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                l2.add(candidates[i]);
                issuccess(l1,l2,sum+candidates[i],candidates,target,i);
                l2.remove(l2.size()-1);

            }
        }
    }

}

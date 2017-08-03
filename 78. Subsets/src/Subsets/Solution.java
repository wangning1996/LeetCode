package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l1 =new ArrayList<>();
        List<Integer> l2 =new ArrayList<>();
        l1.add(l2);
        helper(l1,l2,nums,0);
        return l1;
    }
    public static void helper(List<List<Integer>> l1,List<Integer> l2, int[] nums,int start){
        if(start==nums.length) {
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(i<nums.length-1&&nums[i]==nums[i+1]) continue;
            l2.add(nums[i]);
            l1.add(new ArrayList<>(l2));
            helper(l1,l2,nums,i+1);
            l2.remove(l2.size()-1);

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1,1,2,3,4,4}));
    }
}

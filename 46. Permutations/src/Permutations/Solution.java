package Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,nums,0);
        return list;

    }
    private static void dfs(List<List<Integer>> list,int[] nums,int length){
        if(length==nums.length){
            List<Integer> row = new ArrayList<>() ;
            for (int nu:
                    nums) {
                row.add(nu);
            }
            list.add(row);
        }
        for (int i = length; i <nums.length; i++) {

            swap(nums,i,length);
            dfs(list,nums,length+1);
            swap(nums,i,length);
        }
    }
    private static void swap(int[] nums,int i ,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

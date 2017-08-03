package SumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==3) return nums[0]+nums[1]+nums[2];
        List<List<Integer>> rows= new ArrayList<>();
        Arrays.sort(nums);
        int closednum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int t=nums[left]+nums[right]+nums[i];
                if(t==target) return target;
                //System.out.println(""+nums[i]+nums[left]+nums[right]+t);
                if(Math.abs(t-target)<Math.abs(closednum-target)) {
                    closednum=t;
                    //System.out.println(closednum);
                    while (left<right&&nums[left] == nums[left+1]) { left++;}
                    while (left<right&&nums[right] == nums[right-1]) { right--;}
                }
                if(t<target)
                    left++;
                else
                    right--;
            }
        }
        return closednum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int []ss={0,2,1,-3};
        System.out.println(s.threeSumClosest(ss,1));
    }
}

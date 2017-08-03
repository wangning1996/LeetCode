package Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rows= new ArrayList<>();
        Arrays.sort(nums);
        for(int k = 0 ; k<nums.length-3;k++){
            if (k > 0 && nums[k] == nums[k-1]) continue;
            int tt=target-nums[k];
            for(int i=k+1;i<nums.length-2;i++){
                if (i > (k+1) && nums[i] == nums[i-1]) continue;
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    int t=nums[left]+nums[right]+nums[i];
                    if(t>tt) {
                        right--;
                    }
                    else if(t<tt){
                        left++;
                    }

                    else{
                        List<Integer> ins = new ArrayList<>();
                        ins.add(nums[k]);
                        ins.add(nums[i]);
                        ins.add(nums[left]);
                        ins.add(nums[right]);
                        rows.add(ins);
                        while (left<right&&nums[left] == nums[left+1]) { left++;}
                        while (left<right&&nums[right] == nums[right-1]) { right--;}
                        left++;
                        right--;
                    }
                }
            }
        }
        return rows;
    }
}

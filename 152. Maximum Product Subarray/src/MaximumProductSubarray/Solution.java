package MaximumProductSubarray;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int global=nums[0];
        int localmax=nums[0];
        int localmin=nums[0];
        for(int i=1;i<nums.length;i++){
            int copymax = localmax;
            localmax=Math.max(Math.max(nums[i],localmax*nums[i]),localmin*nums[i]);
            localmin=Math.min(Math.min(nums[i],localmin*nums[i]),copymax*nums[i]);
            global=Math.max(localmax,global);
        }
        return global;
    }
}

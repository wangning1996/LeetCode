package KthLargestElementinanArray;

import java.util.Arrays;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length) return 0;
        if(k<1) return 0;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

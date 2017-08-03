package HouseRobber;

/**
 * Created by wangning on 2017/8/3.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        int m = nums.length;
        int[] arr = new int[m];
        arr[0]=nums[0];
        for(int i=0;i<m;i++){
            if(i==0)
                arr[i]=nums[i];
            else if(i==1)
                arr[i]=Math.max(arr[i-1],nums[i]);
            else
                arr[i]=Math.max(arr[i-1],arr[i-2]+nums[i]);
        }
        return arr[m-1]>arr[m-2]?arr[m-1]:arr[m-2];
    }
}

package HouseRobberII;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        int m = nums.length;
        int[] arr = new int[m];
        arr[0]=nums[0];
        int max=0;
        for(int i=0;i<m-1;i++){
            if(i==0)
                arr[i]=nums[i];
            else if(i==1)
                arr[i]=Math.max(arr[i-1],nums[i]);
            else
                arr[i]=Math.max(arr[i-1],arr[i-2]+nums[i]);
        }
        max=Math.max(Math.max(arr[m-1],arr[m-2]),max);
        arr[1]=nums[1];
        for(int i=1;i<m;i++){
            if(i==1)
                arr[i]=nums[i];
            else if(i==2)
                arr[i]=Math.max(arr[i-1],nums[i]);
            else
                arr[i]=Math.max(arr[i-1],arr[i-2]+nums[i]);
        }
        max=Math.max(Math.max(arr[m-1],arr[m-2]),max);
        return max;
    }
}

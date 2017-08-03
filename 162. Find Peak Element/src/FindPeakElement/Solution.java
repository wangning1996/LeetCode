package FindPeakElement;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int flg=0;
        for(int i=0;i<nums.length-1;i++){
            if(i==0&&nums[i]>nums[i+1]) return 0;
            if(i>0&&nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }
}

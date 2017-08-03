package FindMinimuminRotatedSortedArray;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int findMin(int[] nums) {
        int flg=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                flg=i+1;
                break;
            }
        }
        return nums[flg];
    }
}

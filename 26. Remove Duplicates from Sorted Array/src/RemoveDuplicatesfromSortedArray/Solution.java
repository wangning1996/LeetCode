package RemoveDuplicatesfromSortedArray;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int j=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }

        }
        return j+1;
    }
}

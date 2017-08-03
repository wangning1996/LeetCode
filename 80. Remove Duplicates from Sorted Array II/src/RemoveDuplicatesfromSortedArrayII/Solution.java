package RemoveDuplicatesfromSortedArrayII;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        if(nums.length==2) return 2;
        int j=0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                j++;
                count=0;
                nums[j]=nums[i];
            }
            else if(nums[i]==nums[j]&&count<1){
                count++;
                j++;
                nums[j]=nums[i];
            }
            else
            {

            }
        }
        return j+1;
    }
}

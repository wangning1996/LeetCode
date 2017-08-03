package SearchInsertPosition;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
            else if(nums[i]<target)
                res++;
            else
                return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int a[]={1,3,5,6};
        Solution s= new Solution();
        System.out.println(s.searchInsert(a,2));
    }
}

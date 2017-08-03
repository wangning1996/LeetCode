package SingleNumber;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        //异或运算，两次相同即为0
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}

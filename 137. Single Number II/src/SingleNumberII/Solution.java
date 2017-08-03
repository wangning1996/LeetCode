package SingleNumberII;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] count=new int[32];
        int result=0;
        for(int i=0;i<32;i++){
            for(int j=0;j<nums.length;j++){
                count[i]+=((nums[j]>>i)&1); //首先把输入数字的第i位加起来。
                count[i]=count[i]%3; //然后求它们除以3的余数。
            }
            result|=(count[i]<<i);//把二进制表示的结果转化为十进制表示的结果
        }
        return result;
    }
}

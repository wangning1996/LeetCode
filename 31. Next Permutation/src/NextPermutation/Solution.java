package NextPermutation;

import java.util.Arrays;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int leng=nums.length;
        //从后向前找nums[i]<nums[i+1]的i值并记录
        int first=leng-1;
        for(int i=leng-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                first=i;
                break;
            }
        }
        //判断first的位置
        if(first==leng-1){//说明未找到，故nums为降序排序，需要将其降序
            Arrays.sort(nums);
        }
        else{
            //从后向前找比   nums[first]  大的第一个数并记录位置 ，此时end一定存在
            int end = leng;
            for(int i=leng-1;i>=0;i--){
                if(nums[i]>nums[first]){
                    end=i;
                    break;
                }
            }
            //交换first和end的数
            int temp=nums[first];
            nums[first]=nums[end];
            nums[end]=temp;

            //将first之后的数组重新按从小到大的顺序排序
            Arrays.sort(nums,first+1,leng);
        }
    }
}

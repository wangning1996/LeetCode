package MaximumGap;

import java.util.Arrays;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        //计算划分长度
        double len=1.0*(max-min)/(nums.length-1);
        //如果全部相同返回0
        if(len==0) return 0;
        //计算桶的个数
        int count = (int)Math.floor((max-min)/len+1);
        //申请count个桶，每个桶中都有各自的最大值最小值
        int[] maxbucket = new int[count];
        int[] minbucket = new int[count];
        Arrays.fill(minbucket, Integer.MAX_VALUE);
        Arrays.fill(maxbucket, Integer.MIN_VALUE);
        //元素分入桶中
        for(int i=0;i<nums.length;i++){
            //求出应放入的桶的编号
            int id = (int)Math.floor((nums[i] - min) / len);
            //将其放入桶，并更新桶中最大值最小值
            minbucket[id] = Math.min(minbucket[id], nums[i]);
            maxbucket[id] = Math.max(maxbucket[id], nums[i]);
        }
        //第一个桶包含最小值，因此一定不为空
        int res = 0, premax = maxbucket[0];
        //对于每个桶,如果桶中有元素（即最小值存在），比较桶之间的跨度（用桶的最小值 - 前一个存在值的桶中的最大值，再和当前最大差进行比较）
        for(int i = 1;i<count; i++)
        {
            if(minbucket[i] != Integer.MAX_VALUE)
            {
                res = Math.max(res, minbucket[i] - premax);
                premax = maxbucket[i];
            }
        }
        return res;
    }
}

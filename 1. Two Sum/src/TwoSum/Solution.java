package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/7/22.
 */
public class Solution {
   public int[] twoSum(int[] nums, int target) {
        //实例化一个hashmap
        Map<Integer,Integer> hm = new HashMap<>((int)(nums.length/0.75)+2);
        //循环存入hashmap,过滤掉重复元素
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i);
        }
        //进行减法操作，如果差在hashmap中，则输出其对应的value
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
                if (hm.containsKey(temp)&&hm.get(temp)!=i) {
                    return hm.get(temp) > i ? new int[]{i, hm.get(temp)} : new int[]{hm.get(temp), i};
                }
        }
        //若查找不到则无解决方案
        throw new IllegalArgumentException("无解决方案");
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int [] nums = new int[]{3,3
        };
        int [] num = s.twoSum(nums,6);
        System.out.println(num[0]);
        System.out.println(num[1]);
    }
}

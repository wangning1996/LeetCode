package TwoSumII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //实例化一个hashmap
        Map<Integer,Integer> hm = new HashMap<>((int)(numbers.length/0.75)+2);
        //循环存入hashmap,过滤掉重复元素
        for (int i = 0; i < numbers.length; i++) {
            hm.put(numbers[i],i);
        }
        //进行减法操作，如果差在hashmap中，则输出其对应的value
        for(int i=0;i<numbers.length;i++){
            int temp = target-numbers[i];
            if (hm.containsKey(temp)&&hm.get(temp)!=i) {
                return hm.get(temp) > i ? new int[]{i+1, hm.get(temp)+1} : new int[]{hm.get(temp)+1, i+1};
            }
        }
        //若查找不到则无解决方案
        throw new IllegalArgumentException("无解决方案");
    }
}

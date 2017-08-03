package LongestConsecutiveSequence;

import java.util.HashMap;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(!map.containsKey(n)){
                int left = map.containsKey(n-1)?map.get(n-1):0;
                int right = map.containsKey(n+1)?map.get(n+1):0;
                int sum=left+right+1;
                res = Math.max(res,sum);
                map.put(n,sum);
                map.put(n-left,sum);
                map.put(n+right,sum);
            }
        }
        return res;
    }
}

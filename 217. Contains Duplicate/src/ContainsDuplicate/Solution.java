package ContainsDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<=1) return false;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }
        boolean flg =false;
        for(Integer i : map.keySet()){
            if(map.get(i)>1)
                return true;
        }
        return flg;
    }
}

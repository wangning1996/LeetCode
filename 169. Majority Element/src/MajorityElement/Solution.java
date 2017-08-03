package MajorityElement;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
                map.put(nums[i],1);
        }
        int s=0;
        for (Integer i: map.keySet()) {
            if(map.get(i)>nums.length/2){
                s=i;
                break;
            }
        }
        return s;
    }
}

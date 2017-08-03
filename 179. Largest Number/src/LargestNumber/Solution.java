package LargestNumber;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==0) return "";
        String[] s = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return -s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String te : s)
            sb.append(te);
        while(sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        return sb.toString();
    }
}

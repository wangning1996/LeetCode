package LongestCommonPrefix;

import java.util.Arrays;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        Arrays.sort(strs);
        int length= strs[0].length();
        int t= strs.length;
        StringBuilder result = new StringBuilder(length);
        for(int i = 0;i<length;i++){
            if(strs[0].charAt(i)==strs[t-1].charAt(i)){
                result.append(strs[0].charAt(i));
            }
            else
                return result.toString();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String [] a = new String[]{"[]"};
        System.out.println(s.longestCommonPrefix(a));
    }
}

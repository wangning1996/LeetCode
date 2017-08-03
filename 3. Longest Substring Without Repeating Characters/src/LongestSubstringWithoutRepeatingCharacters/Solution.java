package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/7/22.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
       /*
        将已知字符串从头开始遍历，在每两个重复的字母之间的就是其连续的不含有重复字母的子串
        以length记录下从头开始第一个子串的长度，以一个变量sublength记录之后的子串的长度，比较length和sublength
        取最大的值进行返回
         */
        int length=0;
        int sublength=0;
        int flg=0;
        HashMap<Character,Integer> hm = new HashMap<>((int)(s.length()/0.75)+2);
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))&&hm.get(s.charAt(i))>=flg){
                flg=hm.get(s.charAt(i));
                if(sublength>length){
                    length=sublength;
                }
                sublength=i-flg;
                hm.put(s.charAt(i),i);
            }else{
                hm.put(s.charAt(i),i);
                sublength++;
            }
        }
        return length>sublength?length:sublength;
    }

    public static void main(String[] args) {

        Solution t =new Solution();
        System.out.println(t.lengthOfLongestSubstring("dsdsdsabsa"));
    }
}

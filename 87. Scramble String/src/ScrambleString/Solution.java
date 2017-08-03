package ScrambleString;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))  return true;
        int[] le = new int[26];
        for(int i=0;i<s1.length();i++){
            le[s1.charAt(i)-'a']++;
            le[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<s1.length();i++){
            if(le[i]!=0){
                return false;
            }
        }
        for(int i=1;i<s1.length();i++){
            if (isScramble(s1.substring(0,i), s2.substring(0,i))&& isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))&& isScramble(s1.substring(i), s2.substring(0,s2.length()-i)))
                return true;
        }
        return false;
    }
}

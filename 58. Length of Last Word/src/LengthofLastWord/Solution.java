package LengthofLastWord;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.length()==0)return 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                return s.length()-1-i;
            }
        }
        return s.length();
    }
}

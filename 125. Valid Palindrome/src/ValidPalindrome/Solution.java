package ValidPalindrome;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int m = s.length();
        int j=0;
        int i=m-1;
        while(j<i){
            if(s.charAt(j)<'0'||(s.charAt(j)>'9'&&s.charAt(j)<'a')||s.charAt(j)>'z'){
                j++;
                continue;
            }
            if(s.charAt(i)<'0'||(s.charAt(i)>'9'&&s.charAt(i)<'a')||s.charAt(i)>'z'){
                i--;
                continue;
            }
            if(s.charAt(j)==s.charAt(i)){
                j++;
                i--;
            }
            else
                return false;
        }
        return true;
    }
}

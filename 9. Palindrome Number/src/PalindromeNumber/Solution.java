package PalindromeNumber;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        StringBuilder s =new StringBuilder().append(x);
        int t=s.length();
        for(int i=0,j=t-1;i<(t+1)/2;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(s.isPalindrome(11));
    }
}

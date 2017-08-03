package ReverseBits;

import java.util.Arrays;

/**
 * Created by wangning on 2017/8/3.
 */
public class Solution {
    public int reverseBits(int n) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        System.out.println(s);
        s=s.reverse();
        for(int i=s.length();i<32;i++){
            s.append("0");
        }
        System.out.println(s.length());
        int sum=0;
        for(int i=0;i<32;i++){
            sum=sum*2+s.charAt(i)-'0';
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
    }
}

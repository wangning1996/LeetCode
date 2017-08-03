package Numberof1Bits;

/**
 * Created by wangning on 2017/8/3.
 */
public class Solution {
    public int hammingWeight(int n) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        int length=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                length++;
        }
        return length;
    }
}

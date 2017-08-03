package PlusOne;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int rest=1;
        for(int i=digits.length-1;i>=0;i--){
            if(rest!=0) {
                int n = digits[i] + rest;
                rest = n / 10;
                digits[i] = n % 10;
            }
        }
        if(rest!=0)
        {
            int[] res = new int[digits.length+1];
            res[0]=rest;
            for(int i=1;i<res.length;i++){
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }
}

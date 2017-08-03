package FactorialTrailingZeroes;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int trailingZeroes(int n) {
        return n/5==0?0:n/5+trailingZeroes(n/5);
    }
}

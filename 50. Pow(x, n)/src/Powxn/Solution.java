package Powxn;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 1.0 / helper(x, -n);

        return helper(x, n);
    }
    public static double helper(double x, int n){
        if (n == 0)
            return 1;
        double res = helper(x, n / 2);
        if (n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }
}

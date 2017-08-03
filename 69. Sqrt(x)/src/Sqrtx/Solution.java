package Sqrtx;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int mySqrt(int x) {
        int l=0;
        int r=x;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid*mid>x)
                r=mid;
            else if(mid*mid<x)
                l=mid;
            else
                return mid;
        }
        return l;
    }
}

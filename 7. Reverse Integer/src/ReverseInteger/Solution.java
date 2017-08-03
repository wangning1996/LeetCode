package ReverseInteger;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public int reverse(int x) {
        int gg=0;
        long xx=x;
        if(xx<0){
            gg=1;
            xx=-xx;
        }
        long t=0;
        while (xx != 0) {
            t = t * 10 + xx % 10;
            xx = xx / 10;
        }
        if(t<=2147483647) {
            return gg == 0 ? (int) t : (int) -t;
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-2147483648));
    }
}

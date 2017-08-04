package BitwiseANDofNumbersRange;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m << i);
    }
}

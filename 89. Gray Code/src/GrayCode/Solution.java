package GrayCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++)
            result.add(i ^ i>>1);
        return result;
    }
}

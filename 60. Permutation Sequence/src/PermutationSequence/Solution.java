package PermutationSequence;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {

    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        for(int i = 2; i <= n - 1; i ++)
            factorial *= i;
        for(int i = 1; i <= n; i ++)
            list.add(i);
        k --;
        int round = n - 1;
        while(round >= 0) {
            int num = list.get(k / factorial);
            sb.append(num);
            list.remove(k / factorial);
            if(round > 0) {
                k = k % factorial;
                factorial /= round;
            }
            round --;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3,5));
    }
}

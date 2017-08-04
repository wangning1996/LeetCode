package HappyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        return happy(n,list);
    }
    public boolean happy(int n,List<Integer> list) {
        if(n==1) return true;
        int sum=0;
        while(n!=0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        if(list.contains(sum)){
            return false;
        }
        else{
            list.add(sum);
            return happy(sum,list);
        }
    }
}

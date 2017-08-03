package DecodeWays;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int m=s.length();
        int[] nums = new int[m+1];
        nums[0]=1;
        for(int i=1;i<=m;i++){
            if(s.charAt(i-1)!='0')
                nums[i]+=nums[i-1];
            if(i>1&&s.charAt(i-2)=='1')
                nums[i] += nums[i-2];
            if(i>1&&s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'&&s.charAt(i-1)>='0')
                nums[i] += nums[i-2];
        }
        return nums[m];
    }
}

package StringtoInteger;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public int myAtoi(String str) {
        str=str.trim();
        str+=" ";
        double sum=0;
        //判断有没有第一个符号位
        int flg=-1;
        //判断是不是连续数字
        int flg3=0;

        if((str.charAt(0)<'0'||str.charAt(0)>'9')&&str.charAt(0)!='-'&&str.charAt(0)!='+')
            return 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                flg3=1;
                sum=sum*10+(str.charAt(i)-'0');
            }
            if((str.charAt(i)<'0'||str.charAt(i)>'9')&&flg3==1) {
                break;
            }
            if(str.charAt(i)=='-'&&flg==-1){
                if(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9') {
                    flg = 1;
                    continue;
                }
                else
                    return 0;
            }
            if(str.charAt(i)=='+'&&flg==-1){
                if(str.charAt(i+1)>='0'&&str.charAt(i+1)<='9') {
                    flg = 0;
                    continue;
                }
                else
                    return 0;
            }
            if(str.charAt(i)=='-'&&flg!=-1){
                return 0;
            }
            if(str.charAt(i)=='+'&&flg!=-1){
                return 0;
            }
        }
        if(flg==-1||flg==0){
            if(sum>=2147483647) return 2147483647;
            else return (int)sum;
        }
        else if(flg==1) {
            if (-sum <= -2147483648) {
                return -2147483648;

            }
           else return -(int) sum;
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-2147483648"));
    }
}

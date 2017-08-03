package ValidNumber;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public boolean isNumber(String s) {
        s=s.trim().toLowerCase();
        int a=0;//记录e出现次数
        int b=0;//记录.出现次数
        //去掉字符串前面的0
        int num=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)=='0'&&s.charAt(i)!='0'){
                num=i;
                break;
            }
        }
        s=s.substring(num,s.length());
        if(s.charAt(0)=='e'||s.charAt(0)=='.') return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') continue;
            else if(s.charAt(i)=='e')
            {
                if(a==0)
                    a++;
                else
                    return false;
            }
            else if(s.charAt(i)=='.')
            {
                if(b==0)
                    b++;
                else
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}

package ReverseWordsinaString;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s=s.trim();
        int j=s.length();
        boolean fl =false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                fl=true;
                break;
            }
        }
        if(!fl) return s;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                int flg=i+1;
                if(flg!=j)
                    sb.append(" ");
                while(flg<j){
                    sb.append(s.charAt(flg));
                    flg++;
                }

                j=i;
            }
            if(i==0){
                int flg=i;
                sb.append(" ");
                while(flg<j){
                    sb.append(s.charAt(flg));
                    flg++;
                }

                j=i;
            }
        }
        return sb.toString().trim();
    }
}

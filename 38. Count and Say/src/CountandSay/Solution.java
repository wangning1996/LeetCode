package CountandSay;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n<1) return "";
        String s = "1";
        for(int i=1;i<n;i++){
            s=ins(s);
        }
        return s;
    }
    public static String ins(String s){
        if(s.length()==1) return "1"+s;
        StringBuilder t = new StringBuilder(s.length()*2);
        int count=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }
            else{
                t.append(count);
                t.append(s.charAt(i));
                count=1;

            }
            if(i==s.length()-2) {
                t.append(count);
                t.append(s.charAt(i+1));
            }
        }
        return t.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(1));
    }
}

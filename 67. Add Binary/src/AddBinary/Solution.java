package AddBinary;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public String addBinary(String a, String b) {
        int m=a.length();
        int n=b.length();
        if(m==0) return b;
        if(n==0) return a;
        int i=m-1;
        int j=n-1;
        int rest=0;
        StringBuilder sb =new StringBuilder();
        while(i>=0||j>=0){
            if(i>=0){
                rest+= a.charAt(i)-'0';
                i--;
            }
            System.out.println("i  "+i+"  re  "+rest);
            if(j>=0){
                rest+=b.charAt(j)-'0';
                j--;
            }
            System.out.println("j   "+j+"  re  "+rest);
            sb.append(rest%2);
            rest=rest/2;
        }
        if(rest!=0) sb.append(rest);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010","1011"));
    }
}

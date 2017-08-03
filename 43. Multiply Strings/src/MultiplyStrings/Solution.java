package MultiplyStrings;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int[] num3 = new int[len1+len2];
        int rest=0;//进位
        int product=0;
        int i=0,j=0;
        for(i=num1.length()-1;i>=0;i--){
            rest=0;
            for(j=num2.length()-1;j>=0;j--){
                //对应位相乘+进位
                product=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+rest+num3[i+j+1];
                num3[i+j+1]=product%10;
                rest=product/10;
            }
            num3[i+j+1] = rest;
        }
        StringBuilder ji = new StringBuilder();
        i=0;
        while (i<num3.length-1&&num3[i]==0){
            i++;
        }
        while (i<num3.length){
            ji.append(num3[i++]);
        }
        return ji.toString();
    }
}

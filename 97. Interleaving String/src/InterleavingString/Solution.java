package InterleavingString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ss1 = s1.toCharArray();
        char[] ss2=s2.toCharArray();
        char[] ss3 =s3.toCharArray();
        boolean[][] arr = new boolean[ss1.length+1][ss2.length+1];
        for(int i=0;i<=ss1.length;i++){
            for(int j=0;j<=ss2.length;j++){
                if(i==0&&j==0){
                    arr[i][j]=true;
                }
                else if(j>0&&i==0){
                    arr[i][j]=(arr[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                }
                else if(i>0&&j==0){
                    arr[i][j]=(arr[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
                }
                else
                {
                    arr[i][j]=(arr[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(arr[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
                }
            }
        }
        return arr[ss1.length][ss2.length];
    }

}

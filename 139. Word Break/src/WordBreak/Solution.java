package WordBreak;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        arr[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]&&wordDict.contains(s.substring(j,i))) {
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[s.length()];
    }

    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.add("a");
        word.add("abc");
        word.add("b");
        word.add("cd");

    }
}

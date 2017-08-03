package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        helper("",s, solutions, 0, 0);
        return solutions;
    }
    public static void helper(String temp,String s,List<String> list,int index,int count){
        if(index==s.length()&&count==4){
            list.add(temp);
        }
        if(count>4) return;
        for(int i=1;i<4;i++){
            if(index+i>s.length())
                break;
            String tt  = s.substring(index,index+i);
            if((tt.startsWith("0")&&tt.length()>1)||(i==3&&Integer.parseInt(tt)>=256)) continue;
            helper(temp+tt+(count==3?"" : "."),s,list,index+i,count+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new String("2").substring(0));
    }
}

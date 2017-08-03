package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        help(list,s,new ArrayList<>(),0,s.length());
        return list;
    }
    private void help(List<List<String>> list,String s, List<String> l2,int start ,int end){
        if(start == end){
            List<String> l1 = new ArrayList<>(l2);
            list.add(l1);
        }
        for(int i=start;i<end;i++){
            String t =s.substring(start,i+1);
            int size=l2.size();
            if(check(t)){
                l2.add(t);
                help(list,s,l2,i+1,end);
                l2.remove(size);
            }
        }
    }
    private boolean check(String s ){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

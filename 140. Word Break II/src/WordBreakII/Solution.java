package WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> lists = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        if(!wordBreak(s,wordDict,map)) return lists;
        help(s,lists,new ArrayList<>(),0,map);
        return lists;
    }
    private void help(String s,List<String> lists,List<String> l2,int start , Map<Integer,List<Integer>> map){
        if(start==s.length()) {
            StringBuilder sb =new StringBuilder();
            for(int i=0;i<l2.size()-1;i++)
                sb.append(l2.get(i)).append(" ");
            sb.append(l2.get(l2.size()-1));
            lists.add(sb.toString());
            return;
        }
        if(map.containsKey(start)) {
            for(int i=0;i<map.get(start).size();i++){
                int t = map.get(start).get(i);
                String ss = s.substring(start,t);
                l2.add(ss);
                help(s,lists,l2,t,map);
                l2.remove(l2.size()-1);
            }
        }
    }
    private boolean wordBreak(String s, List<String> wordDict,Map<Integer,List<Integer>> map) {
        boolean[] arr = new boolean[s.length()+1];
        arr[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]&&wordDict.contains(s.substring(j,i))) {
                    arr[i] = true;
                    if(!map.containsKey(j)){
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        map.put(j,t);
                    }
                    else {
                        map.get(j).add(i);
                    }
                }
            }
        }
        return arr[s.length()];
    }
}

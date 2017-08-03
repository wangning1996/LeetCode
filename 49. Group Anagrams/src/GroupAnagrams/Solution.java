package GroupAnagrams;

import sun.rmi.log.LogInputStream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }
            else{
                List<String> ins = new ArrayList<>();
                ins.add(strs[i]);
                map.put(s,ins);
            }
        }
        for(String s :map.keySet()){
            lists.add(map.get(s));
        }
        return lists;
    }

    public static void main(String[] args) {
        String s ="123";
        char[] ch = s.toCharArray();
        System.out.println(ch);
        String sh = ch.toString();
        System.out.println(sh);
        String ph = new String(ch);
        System.out.println(ph);
    }
}

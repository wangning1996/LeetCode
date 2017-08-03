package WordLadder;

import java.util.*;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs搜索
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int dis = 0;
        while (!queue.isEmpty()){
            dis++;
            int size = queue.size();
            for(int j=0;j<size;j++) {
                String s = new String(queue.peek());
                queue.poll();
                Iterator<String> it =set.iterator();
                while(it.hasNext()){
                    String ss = it.next();
                    if (check(s, ss)) {
                        queue.add(ss);
                        it.remove();

                    }
                    if(check(s,endWord)){
                        return dis+1;
                    }
                }
            }

        }
        return 0;
    }
    private boolean check(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        if(count==1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> wordlist = new ArrayList<>();
        wordlist.add("hot");
        wordlist.add("dot");
        wordlist.add("dog");
        wordlist.add("lot");
        wordlist.add("log");
        wordlist.add("cog");
        System.out.println(new Solution().ladderLength("hit","cog",wordlist));
    }
}

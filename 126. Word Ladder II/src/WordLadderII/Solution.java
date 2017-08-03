package WordLadderII;

import java.util.*;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> fwdQueue = new HashSet<String>(), bckQueue = new HashSet<String>();
        HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
        fwdQueue.add(beginWord);
        bckQueue.add(endWord);
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<List<String>>();
        if(set.contains(endWord)==false) return ans;
        findLadder(fwdQueue, bckQueue, set, true, h);


        List<String> cur = new ArrayList<String>();
        cur.add(beginWord);
        printPath(beginWord, endWord, cur, h, ans);
        return ans;
    }

    private void findLadder(Set<String> fwdQueue, Set<String> bckQueue, Set<String> wordList, boolean direction, HashMap<String, ArrayList<String>> h) {
        boolean found = false;
        if (fwdQueue.size() == 0 || fwdQueue.size() == 0) return;
        if (fwdQueue.size() > bckQueue.size()) {
            findLadder(bckQueue, fwdQueue, wordList, !direction, h);
            return;
        }
        wordList.removeAll(fwdQueue);
        wordList.removeAll(bckQueue);
        Set<String> setNew = new HashSet<String>();

        for (String s : fwdQueue) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char tmpc = chs[i];
                for (char j = 'a'; j <= 'z'; j++) if (j != tmpc) {
                    chs[i] = j;
                    String tmp = new String(chs);

                    if (bckQueue.contains(tmp)) {
                        found = true;
                        addPath(s, tmp, direction, h);
                    } else
                    if (!found && wordList.contains(tmp)) {
                        setNew.add(tmp);
                        addPath(s, tmp, direction, h);
                    }
                }
                chs[i] = tmpc;
            }
        }

        if (!found) {
            findLadder(bckQueue, setNew, wordList, !direction, h);
        }
    }

    private void addPath(String s, String t, boolean dir, HashMap<String, ArrayList<String>> h) {
        String key = dir ? s : t, val = dir ? t : s;
        ArrayList l = h.containsKey(key) ? h.get(key) : new ArrayList<String>();
        l.add(val);
        h.put(key, l);
    }

    private void printPath(String s, String target, List<String> cur, HashMap<String, ArrayList<String>> h, List<List<String>> ans) {
        if (s.equals(target)) {
            ans.add(new ArrayList<String>(cur));
            return;
        }
        if (!h.containsKey(s)) return;
        ArrayList<String> l = h.get(s);
        for (String i : l) {
            cur.add(i);
            printPath(i, target, cur, h, ans);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new Solution().findLadders("hit","cog",wordList));
    }
}

package SubstringwithConcatenationofAllWords;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m=s.length();
        int n=words.length;
        int le=words[0].length();
        List<Integer> list = new ArrayList<>();
        HashMap<String,Integer> h = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(h.containsKey(words[i]))
                h.put(words[i], h.get(words[i])+1);
            else
                h.put(words[i],1);
        }
        HashMap<Character,Integer> character = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(character.containsKey(words[i].charAt(0)))
                character.put(words[i].charAt(0), character.get(words[i].charAt(0))+1);
            else
                character.put(words[i].charAt(0),1);
        }
        HashMap<String,Integer> hs = new HashMap<>(h);
        int count=0;
        int end=0;
        while (end<=m-le*n){
            String s1 = s.substring(end,end+le*n);
            if(!character.containsKey(s1.charAt(0))){
                end+=le;
                continue;
            }
            System.out.println(s1);
            int i=0;
            for(i=0;i<n;i++){
                String s2 = s1.substring(i*le,(i+1)*le);
                System.out.println("s2"+s2);
                if(!hs.containsKey(s2)) {
                    count=0;
                    hs = new HashMap<>(h);
                    break;
                }
                else {
                    int tt=hs.get(s2);
                    hs.put(s2,tt-1);

                    if(tt-1>=0)
                        count++;
                    else
                    {
                        count=0;
                        hs = new HashMap<>(h);
                        break;
                    }

                    if(count==n){//找满window
                        list.add(end);
                        count=0;
                        hs = new HashMap<>(h);
                    }
                }
            }
            System.out.println(i);
            end+=le*i;
            System.out.println(end);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("foofoothefoobarman",new String[]{"foo","bar"}));
    }
}

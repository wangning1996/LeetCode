package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] charmap= {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<digits.length();i++){
            int t=digits.charAt(i)-'0';
            if(i==0){
                for(int j=0;j<charmap[t].length();j++){
                    queue.add(""+charmap[t].charAt(j));
                }
            }else{
                int len=queue.size();
                for(int k=0;k<len;k++){
                    String q=queue.remove();
                    for(int j=0;j<charmap[t].length();j++) {
                        queue.add(q + charmap[t].charAt(j));
                    }
                }
            }
        }
        List<String> ls= new ArrayList<>();
        while(!queue.isEmpty()){
            ls.add(queue.remove());
        }
        return ls;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("233"));
    }
}

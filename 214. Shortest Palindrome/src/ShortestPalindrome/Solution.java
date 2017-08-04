package ShortestPalindrome;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()==0||s.length()==1) return s;
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder();
        s1=s1.reverse();
        //翻转之后加到最后面，加个冗余#目的是防止最大公共前缀后缀数大于s的长度
        //将其翻转再去计算next值的话，最大前缀后缀的长度就是最长回文子序列的长度，翻转之后若相同则再转过来必定回文
        s2.append(s).append("#").append(s1);
        //求出最长回文子序列的长度
        int maxnum = next(s2.toString());
        //此时s是回文串
        if(maxnum==s.length())
            return s;
        else
            return s1+s.substring(maxnum+1);

    }
    //kmp求公共前缀和后缀
    private int next(String s){
        int k=-1;
        int j=0;
        int[] next = new int[s.length()];
        next[0]=-1;
        int n=s.length()-1;
        while(j<n){
            if(k==-1||s.charAt(j)==s.charAt(k)){
                k++;
                j++;
                next[j]=k;
            }
            else{
                k=next[k];
            }
        }
        return next[n];
    }
}

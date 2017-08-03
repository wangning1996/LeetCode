package MinimumWindowSubstring;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public String minWindow(String s, String t) {
        /**
         * 分两种情况，一种是从头开始找，另一种是已经找到了
         * 当从头开始的时候，先记录下在t串中字母的出现次数和字母
         * 用尾指针开始遍历，只要找到在t串的字母，就令计数++，map中计数--，代表找到了一个，不是的则直接跳过，
         * 如果是t中字母但是map中计数为负，则只需要map中计数--，count不再++
         * 因为map中计数代表在找到第一个局部最优解之前总共所有的字母共出现多少次，count代表t中的字母是否都出现了
         * 直至找全t中的字母，即count=t.length（），此时找到的是第一个含有t中字母的串
         * 然后遍历这个串，如果头指针指向的字母不在t中，说明这个可以去掉，如果在就看是否map中计数为负，如果为负，代表这个字母之后还会出现，这个字母也不需要
         * 直至找到map中为0的计数的字母，说明此字母是这个串要包含t所必须的开头字母，至此，从头指针到尾指针便是第一个包含t的局部最优解添加，并记录下
         *
         * 在局部最优解找到后，如何找下一个局部最优呢？
         *
         * 我们知道，局部最优之中也存在着不是t中元素的字母，如果向其后续添加一个字母刚好可以把我上一步计算出的必须的开头字母抵消掉的话，那么如果
         * 此时再去像之前一样遍历现在的串，直至找到下一个必须的开头字母，此时计算出来的便是下次的局部最优，从上一个局部最优的基础上又减掉了0个元素及以上
         *
         *
         * 如此循环直至结束。便能得到全局最优
         */
        int m=s.length();
        int n=t.length();
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(h.containsKey(t.charAt(i)))
                h.put(t.charAt(i), h.get(t.charAt(i))+1);
            else
                h.put(t.charAt(i),1);
        }
        HashMap<Character,Integer> hs = new HashMap<>(h);
        int minlength=Integer.MAX_VALUE;
        int count=0;
        int end=0;
        int start=0;
        int minss=0;
        int minee=0;
        while (end<m){
            if(!hs.containsKey(s.charAt(end))){
                end++;
                continue;
            }
            int tt=hs.get(s.charAt(end));
            hs.put(s.charAt(end),tt-1);
            if(tt-1>=0)
                count++;
            if(count==n){//找满window
                while(start!=end){//通过这次操作截取当前解的最优串
                    if(!hs.containsKey(s.charAt(start))){
                        start++;
                        continue;
                    }
                    if (hs.get(s.charAt(start)) < 0) {
                        hs.put(s.charAt(start), hs.get(s.charAt(start)) + 1);
                        start++;
                        continue;
                    }
                    else
                        break;
                }
                if(minlength>end-start+1){
                    minss=start;
                    minee=end;
                    minlength=end-start+1;
                }
            }
            end++;
        }
        if(minlength==Integer.MAX_VALUE)
            return "";
        else
            return s.substring(minss,minee+1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC","ABC"));
    }
}

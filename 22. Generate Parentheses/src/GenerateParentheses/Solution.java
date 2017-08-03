package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ss = new ArrayList<>();
        tt(ss,"",n,n);
        return ss;
    }
    public static void tt(List<String> li, String s, int l, int r){
        if(l == 0 && r == 0)
            // 当且仅当左右括号数量都为0时，正常结束
            li.add(s);
        if(l > 0)

            tt(li, s + "(", l - 1, r);
        if(r > 0 && l < r)
            // 剩余的右括号数量比左括号多时才能添加右括号
            tt(li, s + ")", l, r - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}

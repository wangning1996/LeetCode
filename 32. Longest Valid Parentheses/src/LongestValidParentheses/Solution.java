package LongestValidParentheses;

import java.util.Stack;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength=0;
        int lastValidIndx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                    if(stack.empty()){
                        lastValidIndx=i+1;
                    }else {
                        stack.pop();
                        if (stack.empty()) {

                            maxLength=Math.max(maxLength, i-lastValidIndx+1);
                        }
                        else{
                            maxLength=Math.max(maxLength, i-stack.peek());
                        }
                    }

            }
        }
        return maxLength;
    }
}

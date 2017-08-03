package ValidParentheses;

import java.util.Stack;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i)==')'){
                    if(!stack.empty()&&stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                if(s.charAt(i)==']'){
                    if(!stack.empty()&&stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                if(s.charAt(i)=='}'){
                    if(!stack.empty()&&stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
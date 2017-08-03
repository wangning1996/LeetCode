package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int result=0;
        for(int i=0;i<tokens.length;i++){
            char[] arr = tokens[i].toCharArray();
            if((arr[0]>='0'&&arr[0]<='9')||(arr.length>1&&arr[0]=='-'&&arr[1]>='0'&&arr[1]<='9')){
                s.push(Integer.parseInt(tokens[i]));
            }
            else{
                int n =s.peek();
                s.pop();
                int m =s.peek();
                s.pop();
                if(arr[0]=='-'){
                    result=m-n;
                }
                else if(arr[0]=='+')
                    result=m+n;
                else if(arr[0]=='*')
                    result=m*n;
                else
                    result=m/n;
                s.push(result);
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "-1", "+"}));
    }
}

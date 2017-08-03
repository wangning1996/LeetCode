package MinStack;

import java.util.Stack;

/**
 * Created by wangning on 2017/8/2.
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.empty()||(!min.empty()&&x<=min.peek())) {

            min.push(x);
        }
    }

    public void pop() {
        int n=min.peek();
        if(n == stack.peek())
        {
            stack.pop();
            min.pop();
        }
        else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

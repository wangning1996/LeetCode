package LargestRectangleinHistogram;

import java.util.Stack;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int result=0;
        s.push(0);
        for(int i=0;i<heights.length;i++){
            if (s.empty() || s.peek() <= heights[i])
                s.push(heights[i]);
            else {
                int count = 0;
                while (!s.empty() && s.peek() > heights[i]) {
                    int h = s.peek();
                    count++;
                    result = Math.max(result, h * count);
                    s.pop();
                }
                while (count>0) {
                    s.push(heights[i]);
                    count--;
                }
                s.push(heights[i]);
            }
        }
        int count = 1;
        while (!s.empty())
        {
            result = Math.max(result, s.peek()*count);
            s.pop();
            count++;
        }//while
        return result;

    }

}

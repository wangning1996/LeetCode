package TrappingRainWater;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end=height.length-1;
        int count=0;
        int curheight=0;
        while(start<end){
            if(height[start]<height[end]){
                curheight=Math.max(curheight,height[start]);
                count+=curheight-height[start];
                start++;
            }else{
                curheight=Math.max(curheight,height[end]);
                count+=curheight-height[end];
                end--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a ={2,0,2};
        System.out.println(new Solution().trap(a));
    }
}

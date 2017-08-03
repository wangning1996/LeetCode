package Candy;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int candy(int[] ratings) {
        //1、与前面的邻居比较，前向遍历权重数组ratings，如果ratings[i]>ratings[i-1]，则A[i]=A[i-1]+1；

        //2、与后面的邻居比较，后向遍历权重数组ratings，如果ratings[i]>ratings[i+1]且A[i]<A[i+1]+1，则更新A，A[i]=A[i+1]+1；

        //3、对A求和即为最少需要的糖果。
        int sum=0;
        int[] nums = new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            nums[i]=1;
        }
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                nums[i]=nums[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&nums[i]<nums[i+1]+1)
                nums[i]=nums[i+1]+1;
        }
        for(int i=0;i<ratings.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
}

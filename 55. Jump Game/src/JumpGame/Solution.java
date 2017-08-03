package JumpGame;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public boolean canJump(int[] nums) {、
        if(nums.length==0) return false;
        int canreach=0;//能到达的最远地方
        for(int i=0;i<=canreach&&i<nums.length-1;i++){
            //找局部最优解
            int local = i +nums[i];//当前所在位置i加上在i处能走的最远距离
            canreach=Math.max(local,canreach);
        }
        //最优的最远距离都到达不了
        if(canreach<nums.length-1)
            return false;
        return true;
    }
}

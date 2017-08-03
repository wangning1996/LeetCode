package JumpGameII;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public int jump(int[] nums) {
        int step=0;
        int canreach=0;
        int lastcanreach=0;
        for(int i=0;i<=canreach&&i<nums.length;i++){
            //如果上一次最远都不能走到这一步，说明要走到这的步数比现在走到这要花费的步数多
            if(i>lastcanreach){
                step++;
                lastcanreach=canreach;
            }
            int local=i+nums[i];
            canreach=Math.max(local,canreach);
        }
        //不能到达最后一步则返回0；
        if(canreach<nums.length-1)
            return 0;
        return step;
    }
    public int ali(int[] nums,int length){
        int global=length;//定义一个全局最优解来计算最小花费
        int used=length;//
        int local=0;
        for(int i=0;i<nums.length;i++){

            local=length+local;//假设切割的已经最优，那么下一步要花费的就是local
            System.out.println("  local"+local);
            global=Math.min(global,local);
            length-=nums[i];
            System.out.println(global);
        }
        return global;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,8,9};
        System.out.println(new Solution().ali(nums,30));
    }
}

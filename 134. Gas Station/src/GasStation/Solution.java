package GasStation;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*我们从0开始以其为起点实验，累加 restGas += gas[i] - cost[i]，一旦在 i 处遇到restGas<0，那么就说明当前选择的起点beg不行，
        需要重新选择，此时我们不应该回去使用 beg+1 作为新起点，因为在beg处，一定有 gas>=cost，
        说明 beg+1 到 i 处的总gas一定小于总的cost，选择其中任何一个作为起点还是不行的，所以应该跳过这些点，
        以 i+1 作为新起点，遍历到 size-1 处就可以结束了，如果找到了可能的起点，我们还要进行验证，走一遍(total)，
        如果没问题那么说明可以。*/
        if (gas.length == 0 || cost.length == 0) return -1;
        int sum = 0;
        int st = 0;
        int total = 0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(sum<0){
                sum=gas[i]-cost[i];
                st=i;
            }
            else{
                sum+=gas[i]-cost[i];
            }
        }
        return total<0?-1:st;
    }
}

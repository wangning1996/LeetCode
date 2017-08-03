package UniqueBinarySearchTrees;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    //由1,2,3,...,n构建的二叉查找树，以i为根节点，左子树由[1,i-1]构成，其右子树由[i+1,n]构成。
//定义f(i)为以[1,i]能产生的Unique Binary Search Tree的数目
//若数组为空，则只有一种BST，即空树，f(0)=1;
//若数组仅有一个元素1，则只有一种BST，单个节点，f(1)=1;
//若数组有两个元素1，2，则有两种可能，f(2)=f(0)*f(1)+f(1)*f(0);
//若数组有三个元素1，2，3，则有f(3)=f(0)*f(2)+f(1)*f(1)+f(2)*f(0)
//由此可以得到递推公式：f(i)=f(0)*f(i-1)+...+f(k-1)*f(i-k)+...+f(i-1)*f(0)
//利用一维动态规划来求解
    //Catalan数
    public int numTrees(int n) {
        int[] catalannums = new int[n+1];
        catalannums[0]=1;
        catalannums[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                catalannums[i]+=catalannums[j]*catalannums[i-j-1];
            }
        }
        return catalannums[n];
    }
}

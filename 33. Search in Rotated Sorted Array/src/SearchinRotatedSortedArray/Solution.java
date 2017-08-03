package SearchinRotatedSortedArray;

import java.io.BufferedReader;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int flg=-1;
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                flg=i;
                break;
            }
        }
        if(flg==-1){
            //升序
            return BinSearch(nums,0,nums.length-1,target);
        }
        else{
            int t= BinSearch(nums,0,flg,target);
            int f= BinSearch(nums,flg+1,nums.length-1,target);
            if(t==-1&&f==-1) return -1;
            else
                return t==-1?f:t;
        }
    }
    public static int BinSearch(int Array[],int low,int high,int key)
    {
        if (low<=high)
        {
            int mid = (low+high)/2;
            if(key == Array[mid])
                return mid;
            else if(key<Array[mid])
                return BinSearch(Array,low,mid-1,key);
            else if(key>Array[mid])
                return BinSearch(Array,mid+1,high,key);
            else
                return -1;
        }
        else
            return -1;
    }
}

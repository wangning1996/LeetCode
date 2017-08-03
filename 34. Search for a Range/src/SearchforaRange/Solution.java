package SearchforaRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int end = -1;
        int l=0;
        int r=nums.length-1;
        int is=-1;
        int in=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]>target){
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                in=mid;
                is=mid;
                break;
            }
        }
        if (is==-1)
            return new int[]{-1, -1};
        while(in>0&&nums[in-1]==target){
            in--;
        }
        while(is<nums.length-1&&nums[is+1]==target){
            is++;
        }
        first=in;
        end=is;
        return new int[]{first,end};
    }
}

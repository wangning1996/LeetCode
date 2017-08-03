package MergeSortedArray;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
            int j=m+i;
            while(j>0&&nums1[j]<nums1[j-1]){
                int temp=nums1[j];
                nums1[j]=nums1[j-1];
                nums1[j-1]=temp;
                j--;
            }
        }
    }
}

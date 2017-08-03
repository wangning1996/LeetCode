package MedianofTwoSortedArrays;

/**
 * Created by wangning on 2017/7/22.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num3= new int[(nums1.length+ nums2.length)+1];
        int i=0;
        int j=0;
        int k=1;
        while(i!=nums1.length&&j!=nums2.length){
            if(nums1[i]>nums2[j]){
                num3[k]=nums2[j];
                j++;
                k++;
            }
            else{
                num3[k]=nums1[i];
                i++;
                k++;
            }
        }
        while(i!=nums1.length){
            num3[k]=nums1[i];
            i++;
            k++;
        }
        while(j!=nums2.length){
            num3[k]=nums2[j];
            j++;
            k++;
        }
        /*for (int m:
             num3) {
            System.out.println(m+"m");
        }*/
        if((num3.length-1)%2==0){
            return (double) (num3[(num3.length-1)/2]+num3[(num3.length-1)/2+1])/2;
        }
        else{
            return num3[(num3.length+1)/2];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num1={1,2};
        int[] num2={3,4};
        System.out.println(s.findMedianSortedArrays(num1,num2));
    }
}

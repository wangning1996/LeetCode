package Searcha2DMatrix;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        if(n==0) return false;
        int up=0;
        int down=m-1;
        int l=0;
        int r=n-1;
        int mid=0;
        int row=0;
        int col=0;
        while(up<=down){
            mid=(down+up)/2;
            if(mid>0&&matrix[mid-1][n-1]<target&&matrix[mid][n-1]>target){
                row=mid;
                break;
            }
            if(mid==0&&matrix[mid][n-1]>target){
                row=0;
                break;
            }
            if(matrix[mid][n-1]>target)
                down=mid-1;
            else if(matrix[mid][n-1]==target){
                return true;
            }
            else
                up=mid+1;
        }
        while(l<=r){
            mid=(r+l)/2;
            if(matrix[row][mid]>target)
                r=mid-1;
            else if(matrix[row][mid]==target){
                return true;
            }
            else
                l=mid+1;
        }
        return false;
    }
}

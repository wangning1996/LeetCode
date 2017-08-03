package MaximalRectangle;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m= matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int area = 0;
        int[] height =new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++)
            right[i]=n;
        /**
         *
         *  left(i, j) = max(left(i-1, j), cur_left);
            right(i, j) = min(right(i-1, j), cur_right);
            height(i, j) = height(i-1, j) + 1, if matrix[i][j]=='1';
            height(i, j) = 0, if matrix[i][j]=='0'.
         */
        for(int i=0;i<m;i++){
            int curl=0;
            int curr=n;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') ++height[j];
                else height[j] = 0;
            }
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], curl);
                else {left[j] = 0; curl = j + 1;}
            }
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curr);
                else {right[j] = n; curr = j;}
            }
            for (int j = 0; j < n; ++j) {
                area = Math.max(area, (right[j] - left[j]) * height[j]);
            }
        }
        return area;
    }
}

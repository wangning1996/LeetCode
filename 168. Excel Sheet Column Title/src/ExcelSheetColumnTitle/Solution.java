package ExcelSheetColumnTitle;


import java.util.HashMap;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}

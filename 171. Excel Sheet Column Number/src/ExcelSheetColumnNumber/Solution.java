package ExcelSheetColumnNumber;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum=sum*26+(s.charAt(i)-'A'+1);
        }
        return sum;
    }
}

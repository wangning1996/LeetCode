package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        return help(-1,rowIndex,new ArrayList<>());
    }
    private List<Integer> help(int count, int numRows, List<Integer> l2){
        if(count==numRows) return l2;
        else{
            List<Integer> l1 = new ArrayList<>();
            int t=l2.size();
            if(count>-1) l1.add(1);
            for(int i=0;i<t-1;i++){
                l1.add(l2.get(i)+l2.get(i+1));
            }
            l1.add(1);
            l2=help(count+1,numRows,l1);
            return l2;
        }
    }
}

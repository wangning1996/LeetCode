package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/30.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0) return list;

        return help(0,numRows,list,new ArrayList<>());


    }
    private List<List<Integer>> help(int count,int numRows,List<List<Integer>> list,List<Integer> l2){
        if(count==numRows) return list;
        else{
            List<Integer> l1 = new ArrayList<>();
            int t=l2.size();
            if(count>0) l1.add(1);
            for(int i=0;i<t-1;i++){
                l1.add(l2.get(i)+l2.get(i+1));
            }
            l1.add(1);
            list.add(l1);
            list=help(count+1,numRows,list,l1);
            return list;
        }

    }
}

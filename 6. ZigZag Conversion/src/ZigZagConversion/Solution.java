package ZigZagConversion;

/**
 * Created by wangning on 2017/7/23.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        //设置默认方向，向下排列为1，向上为0
        int direction=1;
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i =0;i<numRows;i++){
            arr[i]=new StringBuilder(s.length()/numRows+3);
        }
        int j=0;

        for (int i=0;i<s.length();i++) {
            //方向向下则行数应该+1
            if(direction==1&&j<numRows) {
                //走到最后一行时更换方向，下个位置应该是当前位置的上一行
                if (j == numRows - 1) {
                    direction = 0;
                    arr[j].append(s.charAt(i));
                    //System.out.println("arr[" + j + "]:" + i + "   " + s.charAt(i));
                    j--;
                }
                else{
                    arr[j].append(s.charAt(i));
                    //System.out.println("arr[" + j + "]:" + i + "   " + s.charAt(i));
                    j++;
                }

            }
            else if(direction==0&&j>=0){
                //走到第一行时更换方向,下个位置应该是当前位置的下一行
                if (j == 0) {
                    direction = 1;
                    arr[j].append(s.charAt(i));
                    //System.out.println("arr[" + j + "]:" + i + "   " + s.charAt(i));
                    j++;
                }
                else{
                    arr[j].append(s.charAt(i));
                    //System.out.println("arr[" + j + "]:" + i + "   " + s.charAt(i));
                    j--;
                }

            }
        }
        StringBuilder t=new StringBuilder(numRows+1);
        for (StringBuilder str:arr){
            t.append(str);
        }
        return t.toString();
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.convert("AB",1));
    }
}

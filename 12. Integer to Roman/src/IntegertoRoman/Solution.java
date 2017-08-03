package IntegertoRoman;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuilder str=new StringBuilder(30);
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        for(int i=0;num!=0;++i)
        {
            while(num>=value[i])
            {
                num-=value[i];
                str.append(symbol[i]);
            }
        }
        return str.toString();
    }
}

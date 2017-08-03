package MaxPointsonaLine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangning on 2017/8/2.
 */
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
public class Solution {
    public int maxPoints(Point[] points) {
        int maxn=0;
        if (points.length < 3) return points.length;
        for(int i=0;i<points.length;i++){
            Map<Integer,Map<Integer,Integer>> map1 = new HashMap<>();
            int dup=0;
            int max=0;
            //求和别的点的斜率
            for (int j=0;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    dup++;
                    continue;
                }
                else{
                    int gcd = generateGCD(x, y);
                    if (gcd != 0) {
                        x = x / gcd;
                        y = y / gcd;
                    }
                }
                if(map1.containsKey(x)){
                    if(map1.get(x).containsKey(y))
                        map1.get(x).put(y,map1.get(x).get(y)+1);
                    else
                        map1.get(x).put(y, 1);
                }
                else{
                    Map<Integer,Integer> map2=new HashMap<>();
                    map2.put(y,1);
                    map1.put(x,map2);
                }
                max = Math.max(max, map1.get(x).get(y));
            }

            maxn = Math.max(max + dup, maxn);
        }
        return maxn;
    }
    private int generateGCD(int x, int y) {
        if (y == 0)
            return x;
        return generateGCD(y, x % y);
    }
}

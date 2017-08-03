package CompareVersionNumbers;

import sun.nio.cs.ext.MacHebrew;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int m = ver1.length;
        int n = ver2.length;
        System.out.println(m);
        System.out.println(n);
        for(int i=0;i<Math.min(m,n);i++){
            System.out.println(Integer.parseInt(ver1[i]));
            System.out.println(Integer.parseInt(ver2[i]));
            if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i]))
                return -1;
            else if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i]))
                return 1;
            else
                continue;
        }
        if(m>n) {
            for (int i = n; i < m; i++) {
                if(Integer.parseInt(ver1[i])==0)
                    continue;
                else
                    return 1;
            }
        }
        if(m<n) {
            for (int i = m; i < n; i++) {
                if(Integer.parseInt(ver2[i])==0)
                    continue;
                else
                    return -1;
            }
        }
       return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.01","1.1"));
    }
}

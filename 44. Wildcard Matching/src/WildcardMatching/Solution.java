package WildcardMatching;

/**
 * Created by wangning on 2017/7/26.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length()==0&&p.length()==0) return true;
        if(s.length()!=0&&p.length()==0) return false;
        char[] a=s.toCharArray();
        char[] b=p.toCharArray();
        boolean[][] res=new boolean[b.length+1][a.length+1];
        res[0][0]=true;
        for(int i=1;i<=b.length;i++){
            res[i][0]=res[i-1][0]&&b[i-1]=='*';
            for(int j=1;j<=a.length;j++){
                if(b[i-1]=='*'){
                    res[i][j]=res[i-1][j]||res[i][j-1];//取上或左的值，只要一个为true，则说明当前匹配也能成功，*代替了一个或者为空
                }
                if(b[i-1]=='?'||b[i-1]==a[j-1]){
                    res[i][j]=res[i-1][j-1];//正常匹配，当前是否匹配成功取决于前一个是否成功
                }
            }
        }
        return res[b.length][a.length];
    }
}

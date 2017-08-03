package RegularExpressionMatching;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public boolean isMatch(String s, String p) {

        if(s.length()==0&&p.length()==0) return true;
        if(s.length()!=0&&p.length()==0) return false;
        if(p.equals(".*")) return true;
        boolean[][] res = new boolean[s.length()+1][p.length()+1];
        res[0][0]=true;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && res[0][i-1] == true){
                res[0][i + 1] = true;
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='.'||p.charAt(j)==s.charAt(i)){
                    res[i+1][j+1]=res[i][j];
                }
                else if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)!='.'&&p.charAt(j-1)!=s.charAt(i)){
                        res[i+1][j+1]=res[i+1][j-1];
                    }
                    else{
                        res[i+1][j+1] = res[i+1][j] || res[i+1][j-1] || res[i][j+1];
                    }
                }
            }
        }
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=p.length();j++){
                System.out.println("res["+i+","+j+"]:    "+res[i][j]);
            }
        }
        return res[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aab","b.*"));
    }
}

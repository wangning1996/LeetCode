package SimplifyPath;

import java.util.*;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            //..返回上一目录
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            //非..或者.或者空的时候，都是目录名
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}

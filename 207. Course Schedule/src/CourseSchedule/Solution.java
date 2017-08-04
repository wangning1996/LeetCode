package CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangning on 2017/8/4.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] map = new int[numCourses];
        //给每个点赋值入度
        for(int i=0;i<prerequisites.length;i++){
            map[prerequisites[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的点加入队列
        for(int i=0;i<numCourses;i++){
            if(map[i]==0)
                queue.add(i);
        }
        //遍历队列，重复上述过程
        //记录入度为0的点的个数
        int count=queue.size();
        while(!queue.isEmpty()){
            int k = queue.peek();
            queue.poll();
            //将入度为0的点从队列中去除，然后将其对应的边上的下个结点的入度-1
            for(int i=0;i<prerequisites.length;i++){
                if(k==prerequisites[i][0]){
                    map[prerequisites[i][1]]--;
                    //如果入度为0
                    if(map[prerequisites[i][1]]==0){
                        queue.add(prerequisites[i][1]);
                        count++;
                    }
                }
            }
        }
        //判断是否图中无环，等价于入度为0的点的个数和所给课程数相同
        return count==numCourses;
    }
}

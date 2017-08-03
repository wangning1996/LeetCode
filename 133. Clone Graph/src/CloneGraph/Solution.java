package CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangning on 2017/7/31.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return node;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, root);
        while (!queue.isEmpty()){
            UndirectedGraphNode now = queue.peek();
            queue.poll();
            List<UndirectedGraphNode> nowneighbors = now.neighbors;
            for(UndirectedGraphNode neighbor:nowneighbors){
                if(map.containsKey(neighbor)){
                    map.get(now).neighbors.add(map.get(neighbor));
                }else{
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copy);
                    map.get(now).neighbors.add(copy);
                    queue.add(neighbor);
                }
            }
        }
        return root;
    }
}

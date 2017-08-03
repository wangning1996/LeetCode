package CloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangning on 2017/7/31.
 */
public class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

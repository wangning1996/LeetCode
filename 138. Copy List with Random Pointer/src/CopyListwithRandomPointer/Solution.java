package CopyListwithRandomPointer;

import java.util.HashMap;

/**
 * Created by wangning on 2017/7/31.
 */
class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
 };
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode newhead = new RandomListNode(head.label);
        RandomListNode node1=head;
        RandomListNode node2=newhead;
        while (node1.next!=null){
            map.put(node1,node2);
            node1=node1.next;
            node2.next=new RandomListNode(node1.label);
            node2=node2.next;
        }
        map.put(node1,node2);
        node1=head;
        node2=newhead;
        while (node1.next!=null){
            node2.random=map.get(node1.random);
            node1=node1.next;
            node2=node2.next;
        }
        node2.random=map.get(node1.random);
        return newhead;
    }
}

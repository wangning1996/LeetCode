package MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode l3 = new ListNode(2);
        ListNode head = l3;
        for(ListNode p:lists){
            if(p!=null)
                pq.add(p);
        }
        while(!pq.isEmpty()){
            l3.next=pq.poll();
            l3=l3.next;
            if(l3.next!=null){
                pq.add(l3.next);
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode[] arr = new ListNode[5];
        arr[0] = new ListNode(1);
        arr[1] = new ListNode(2);
        arr[2] = new ListNode(3);
        arr[3] = new ListNode(1);
        arr[4] = new ListNode(4);
        ListNode a =s.mergeKLists(arr);
        while(a!=null){
            System.out.println(a.val);
            a=a.next;
        }
    }
}

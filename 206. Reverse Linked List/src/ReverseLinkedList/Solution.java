package ReverseLinkedList;

/**
 * Created by wangning on 2017/8/4.
 */
class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode qf = new ListNode(0);
        qf.next=head;
        ListNode pf=qf;
        ListNode p = pf.next;
        ListNode q = p.next;
        while(q!=null){
            p.next=q.next;
            q.next=pf.next;
            pf.next=q;
            q=p.next;
        }
        return qf.next;
    }
}

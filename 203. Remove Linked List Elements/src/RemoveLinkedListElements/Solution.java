package RemoveLinkedListElements;

/**
 * Created by wangning on 2017/8/4.
 */
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode p = head;
        ListNode start = new ListNode(0);
        start.next=p;
        ListNode s=start;
        while(p!=null){
            if(p.val==val){
                start.next=p.next;
                p=p.next;
            }
            else{
                start=start.next;
                p=p.next;
            }
        }
        return s.next;
    }
}
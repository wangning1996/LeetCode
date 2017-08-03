package LinkedListCycleII;

/**
 * Created by wangning on 2017/7/31.
 */
class ListNode {
     int val;
    ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return head;
        ListNode s1 = head;
        ListNode s2 = head;
        while(s2.next!=null&&s2.next.next!=null){
            s1=s1.next;
            s2=s2.next.next;
            if(s1==s2) {
                while (head != s1) {
                    head = head.next;
                    s1 = s1.next;
                }
                return s1;
            }
        }
        return null;
    }
}

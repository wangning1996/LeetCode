package RemoveNthNodeFromEndofList;

import java.util.List;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        ListNode start = head;
        ListNode p = head;
        int length=0;
        while(start!=null){
            length++;
            start=start.next;
        }
        if(n==length){
            return head.next;
        }
        for(int i=0;i!=length-n;i++)
            p=p.next;
        if(n==1) {
            p.next=null;
            return head;
        }
        ListNode q=p.next;
        p.next=q.next;
        return head;

    }

}

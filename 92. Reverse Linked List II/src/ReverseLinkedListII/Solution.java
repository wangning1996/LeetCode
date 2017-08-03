package ReverseLinkedListII;

import java.util.List;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        ListNode qf = new ListNode(0);
        qf.next=head;
        ListNode pf=qf;
        for(int i=0;i<m-1;i++){
            pf=pf.next;
        }
        ListNode p = pf.next;
        ListNode q = p.next;
        for(int i=0;i<n-m;i++){
            p.next=q.next;
            q.next=pf.next;
            pf.next=q;
            q=p.next;
        }
        return qf.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        ListNode tt=new Solution().reverseBetween(head,2,4);
        while(tt!=null){
            System.out.println(tt.val);
            tt=tt.next;
        }
    }
}

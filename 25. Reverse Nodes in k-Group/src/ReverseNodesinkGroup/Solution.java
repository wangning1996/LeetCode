package ReverseNodesinkGroup;

import java.util.List;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1||k==0) return head;
        ListNode p = head;
        int leng=0;
        while(p.next!=null){
            leng++;
            p=p.next;
        }
        leng++;
        ListNode start = new
                ListNode(0);
        ListNode te =start;
        if(leng<k)
            return head;
        if(leng==k)
           return reverse(head,p);
        p=head;
        ListNode q=p;

        for(int i=1;q!=null;i++){
            if(i%k==0){
                //将p和q之间的串翻转
                ListNode t = reverse(p,q);
                te.next=t;
                while(te.next!=null){
                    te=te.next;
                }
                p = q.next;
            }
            q=q.next;
        }
        while(te.next!=null){
            te=te.next;
        }
        te.next=p;
        return start.next;
    }
    public static ListNode reverse(ListNode p,ListNode q){
        ListNode head = new ListNode(0);
        while(p!=q){
            ListNode temp = new ListNode(p.val);
            if(head.next!=null)
            temp.next=head.next;
            head.next=temp;
            p=p.next;
        }
        ListNode temp = new ListNode(p.val);
        temp.next=head.next;
        head.next=temp;
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(3);

        ListNode t = s.reverseKGroup(l1,2);
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}

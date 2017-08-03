package ReorderList;

/**
 * Created by wangning on 2017/7/31.
 */


 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

public class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode p = head;
        ListNode rhead = reverse(p);
        p=head;
        int length=0;
        while(p!=null){
            length++;
            p=p.next;
        }
        p=head;
        ListNode q = rhead;
        while(q!=null){
            if(p.next==null){
                p.next=q;
                q=q.next;
                continue;
            }
            else{
                ListNode temp = q;
                q=q.next;
                temp.next=p.next;
                p.next=temp;
                p=p.next.next;
            }
        }
        ListNode s=head;
        for(int i=0;i<length;i++){
            if(i==length-1)
                s.next=null;
            else
                s=s.next;
        }
    }
    private ListNode reverse(ListNode p){
        ListNode head = new ListNode(0);
        while(p!=null){
            ListNode temp = new ListNode(p.val);
            if(head.next!=null)
                temp.next=head.next;
            head.next=temp;
            p=p.next;
        }
        return head.next;
    }
}

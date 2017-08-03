package PartitionList;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode s =new ListNode(0);
        ListNode st = s;
        ListNode p=head;
        ListNode q=head;
        while(p!=null){
            if(p.val<x){
                st.next=new ListNode(p.val);
                st=st.next;
            }
            p=p.next;
        }
        while(q!=null){
            if(q.val>=x){
                st.next=new ListNode(q.val);
                st=st.next;
            }
            q=q.next;
        }
        return s.next;
    }
}

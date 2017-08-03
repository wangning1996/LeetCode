package SortList;

import java.util.List;

/**
 * Created by wangning on 2017/8/2.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
 public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid = getmid(head);
        ListNode l1=sortList(head);
        ListNode l2=sortList(mid);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode l =new ListNode(0);
        ListNode p =l;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                p.next=l2;
                l2=l2.next;
            }else{
                p.next=l1;
                l1=l1.next;
            }
            p=p.next;
        }
        if(l1!=null)
            p.next=l1;
        if(l2!=null)
            p.next=l2;
        return l.next;
    }
    private ListNode getmid(ListNode head){
        ListNode fast = head;
        ListNode slow =head;
        ListNode preslow =head;
        while (fast!=null&&fast.next!=null){
            preslow=slow;
            slow = slow.next;
            fast=fast.next.next;
        }
        preslow.next=null;
        return slow;
    }
}

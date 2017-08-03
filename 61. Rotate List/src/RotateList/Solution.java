package RotateList;

/**
 * Created by wangning on 2017/7/27.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode start =head;
        int length=1;//记录链表长度
        while(start.next!=null){
            length++;
            start=start.next;
        }
        k=k%length;
        //此时start指向最后一个数,让其指向头结点形成环
        start.next=head;
        ListNode p = head;
        ListNode q= start;
        //定义指针指向原来的倒数第k个数
        for(int i=1;i<=length-k;i++){
            p=p.next;
            q=q.next;
        }
        //从此处断开
        q.next=null;
        return p;
    }
}

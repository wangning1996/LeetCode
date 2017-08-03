package InsertionSortList;

import java.util.List;

/**
 * Created by wangning on 2017/8/2.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        ListNode st = new ListNode(Integer.MIN_VALUE);
        ListNode start = st;
        ListNode p = head;
        while(p!=null){
            start = st;
            while(start.next!=null&&start.next.val<p.val){
                start = start.next;
            }
            ListNode temp = p.next;
            p.next=start.next;
            start.next = p;
            p=temp;
        }
        return st.next;
    }

    public static void main(String[] args) {
        ListNode q  = new ListNode(1);
        q.next=new ListNode(1);

        System.out.println();
        ListNode p = new Solution().insertionSortList(q);
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}

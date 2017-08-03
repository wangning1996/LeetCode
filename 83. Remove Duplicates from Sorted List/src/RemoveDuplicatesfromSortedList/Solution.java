package RemoveDuplicatesfromSortedList;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p =head;
        while(p!=null){
            if(p.next!=null) {
                ListNode q = p.next;
                if (q.val == p.val) {
                    if (q.next != null) {
                        p.next = q.next;
                        q = null;
                    } else
                        p.next = null;
                }else
                    p=p.next;
            }
            else
                p = null;
        }
        return head;
    }
}

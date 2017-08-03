package RemoveDuplicatesfromSortedListII;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;

/**
 * Created by wangning on 2017/7/28.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p =head;
        ListNode te= new ListNode(0);
        ListNode s=new ListNode(0);
        s.next=head;
        te.next=p;
        while(p!=null){
            if(p.next!=null) {
                ListNode q = p.next;
                if (q.val == p.val) {
                    System.out.println("p.val"+p.val);
                    while (q!= null&&q.val==p.val) {
                        System.out.println(q.val);
                        q=q.next;
                    }
                    if(q==null){
                        te.next=null;
                        p=null;
                    }else{
                        te.next=q;
                        p=q;
                        System.out.println(p.val);
                    }
                }
                else{
                    p=p.next;
                    te=te.next;
                }
            }
            else
                p = null;

        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        l1.next=new ListNode(1);
        l1.next.next=new ListNode(2);
        System.out.println(new Solution().deleteDuplicates(l1));
    }
}

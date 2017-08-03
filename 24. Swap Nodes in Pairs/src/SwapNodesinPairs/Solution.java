package SwapNodesinPairs;

import java.util.List;

/**
 * Created by wangning on 2017/7/25.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode st=start;
        start.next=head;
        ListNode q=head;
        ListNode p = new ListNode(0);
        while(q!=null){
            //现在所在位置的下一个数字如果存在则可以交换
            if(q.next!=null){
                p=q.next;

                //如果还有下一个，则指向下一个，否则就到了头
                if(p.next!=null)
                    q.next=p.next;
                else
                    q.next=null;
                p.next=q;
                st.next=p;
                //System.out.println(p.val+"  p.val   "+q.val+" q.val  ");
                //交换结束后换下一对
                st=q;
                q=q.next;
            }else
                break;

        }
        return start.next;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new
                ListNode(0);
        /*ListNode p =l1;
        p.next = new ListNode(1);
        p=p.next;
        p.next=new ListNode(2);
        p=p.next;
        p.next=new ListNode(3);
        p=p.next;
        p.next=new ListNode(4);*/

        ListNode t = s.swapPairs(l1.next);
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
}

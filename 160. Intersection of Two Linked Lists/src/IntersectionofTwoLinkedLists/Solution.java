package IntersectionofTwoLinkedLists;

/**
 * Created by wangning on 2017/8/2.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p =headA;
        ListNode q =headB;
        int alength=0;
        while(p!=null){
            alength++;
            p=p.next;
        }
        int blength=0;
        while(q!=null){
            blength++;
            q=q.next;
        }
        p=headA;
        q=headB;
        if(alength>blength){
            for(int i=0;i<alength-blength;i++)
                p=p.next;
        }
        else{
            for(int i=0;i<blength-alength;i++)
                q=q.next;
        }
        while(p!=null&&q!=null){
            if(p.val==q.val)
                break;
            p=p.next;
            q=q.next;
        }
        return p;
    }
}

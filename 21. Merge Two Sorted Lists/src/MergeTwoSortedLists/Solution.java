package MergeTwoSortedLists;

/**
 * Created by wangning on 2017/7/24.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                ListNode p =new ListNode(l1.val);
                l3.next=p;
                l3=l3.next;
                l1=l1.next;
            }
            else{
                ListNode p =new ListNode(l2.val);
                l3.next=p;
                l3=l3.next;
                l2=l2.next;
            }
        }
        while (l1!=null){
            ListNode p =new ListNode(l1.val);
            l3.next=p;
            l1=l1.next;
            l3=l3.next;
        }
        while (l2!=null){
            ListNode p =new ListNode(l2.val);
            l3.next=p;
            l2=l2.next;
            l3=l3.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=s.mergeTwoLists(l1,l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }
    }
}

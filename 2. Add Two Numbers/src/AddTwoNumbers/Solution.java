package AddTwoNumbers;

/**
 * Created by wangning on 2017/7/22.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //先建立头结点,并且做一个备份的指针
        ListNode head =new ListNode(0);
        ListNode p = head;

        //定义一个变量用来存储商
        int rest=0;
        //只要两个链表任意一个不为空，说明可以相加
        while(l1!=null||l2!=null||rest!=0){
            if(l2!=null){
                rest+=l2.val;
                l2=l2.next;
            }
            if (l1!=null) {
                rest+=l1.val;
                l1=l1.next;
            }
            //实例化下一个结点，其值为两结点值相加mod10后再加上上两个数相加的进位
            p.next = new ListNode(rest%10);
            //更新这次的商
            rest=rest/10;
            //指针后移
            p=p.next;
        }
        //说明l1和l2都走到了头
        return head.next;
    }

    public static void main(String[] args) {


        ListNode l1=new ListNode(1);
        ListNode p=l1;

        ListNode l2=new ListNode(9);
        ListNode q = l2;
        l2.next=new ListNode(9);

        l2=l2.next;
        l2.next=new ListNode(9);

        Solution s= new Solution();
       /* while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }

        while(q!=null){
            System.out.println(q.val);
            q=q.next;
        }
        */
        ListNode k= s.addTwoNumbers(p,q);
        while(k!=null){
            System.out.println(k.val);
            k=k.next;
        }
    }
}

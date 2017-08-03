package ConvertSortedListtoBinarySearchTree;

/**
 * Created by wangning on 2017/7/29.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int length=0;
        while(p!=null){
            length++;
            p=p.next;
        }
        int[] nums = new int[length];
        int i=0;
        while(head!=null){
            nums[i]=head.val;
            head=head.next;
            i++;
        }
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int start,int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=build(nums,start,mid-1);
        root.right=build(nums,mid+1,end);
        return root;
    }
}

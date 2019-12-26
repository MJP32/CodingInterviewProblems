package Leetcode.easy;



public class LC21_MergeTwoSortedLists {
    public static void main(String[] args) {

    }
    public Leetcode.zap.todo.submit.ListNode mergeTwoLists(Leetcode.zap.todo.submit.ListNode l1, Leetcode.zap.todo.submit.ListNode l2) {


        Leetcode.zap.todo.submit.ListNode dummy = new Leetcode.zap.todo.submit.ListNode(-1);
        Leetcode.zap.todo.submit.ListNode head = dummy;
        while(l1 != null && l2 !=null){

            if(l1.val < l2.val){
                dummy.next = l1;
                l1 =l1.next;
            }
            else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;


        }

        if(l1!=null){
            dummy.next=l1;
        }
        if(l2!=null){
            dummy.next=l2;
        }



        return head.next;
    }
}

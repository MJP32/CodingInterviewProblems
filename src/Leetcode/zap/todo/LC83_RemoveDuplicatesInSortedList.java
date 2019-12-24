package Leetcode.zap.todo;

public class LC83_RemoveDuplicatesInSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        LC83_RemoveDuplicatesInSortedList lc83 = new LC83_RemoveDuplicatesInSortedList();
        ListNode ls = lc83.deleteDuplicates(node1);

        while(ls != null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if(head==null||head.next==null) return head;

        if(head.val!=head.next.val){
            head.next=deleteDuplicatesRecursive(head.next);
            return head;
        }
        else{
            while(head.next!=null&&head.val==head.next.val)
                head=head.next;

            return   deleteDuplicatesRecursive(head.next);
        }

    }
}

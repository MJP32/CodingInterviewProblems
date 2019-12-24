package Leetcode.zap.todo;

public class LC86_PartitionList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        LC86_PartitionList lc86 = new LC86_PartitionList();
        ListNode ls = lc86.partition(node1, 3);

        while(ls != null){
            System.out.println(ls.val);
            ls = ls.next;
        }
    }
    public ListNode partition(ListNode head, int x){
        ListNode l1, p1,l2, p2, p=head;

        l1=p1=new ListNode(0);
        l2=p2=new ListNode(0);

        while(p != null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
            }
            else{
                p2.next = p;
                p2 = p2.next;
            }

            p=p.next;
        }
        p2.next =null;
        p1.next=l2.next;


        return l1.next;
    }
}

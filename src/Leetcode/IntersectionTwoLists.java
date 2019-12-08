package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLists {


    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(6);
        ListNode l1_3 = new ListNode(9);
        ListNode l1_4 = new ListNode(15);
        ListNode l1_5 = new ListNode(30);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode l2_1 = new ListNode(10);
        ListNode l2_2 = new ListNode(15);
        ListNode l2_3 = new ListNode(30);
        l2_1.next = l2_2;
        l2_2.next = l2_3;


        IntersectionTwoLists itl = new IntersectionTwoLists();


        System.out.println(itl.getIntersectionNode(l1_1,l2_1));

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> set = new HashSet<>();


        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null){
             if(set.contains(headB))
                return headB;
            headB = headB.next;
        }



        return null;

    }



}




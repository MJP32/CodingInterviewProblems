package Leetcode.easy;

import Leetcode.common.ListNode;

import java.util.LinkedHashSet;
import java.util.Set;

public class LC160_IntersectionTwoLists {


    public static void main(String[] args) {

       /* ListNode l1_1 = new ListNode(3);
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
        l2_2.next = l2_3;*/
        ListNode list = new ListNode(3);
        ListNode list2 = new ListNode(10);

        // creating first linked list

        list.next = new ListNode(6);
        list.next.next = new ListNode(9);
        list.next.next.next = new ListNode(15);
        list.next.next.next.next = new ListNode(30);

        // creating second linked list

        list2.next = new ListNode(15);
        list2.next.next = new ListNode(30);

        LC160_IntersectionTwoLists lc160 = new LC160_IntersectionTwoLists();


        System.out.println(lc160.getIntersectionNode(list,list2).val);

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<Integer> set = new LinkedHashSet<>();


        while(headA != null){
            set.add(headA.val);
            headA = headA.next;
        }

        while(headB != null){
             if(set.contains(headB.val))
                return headB;
            headB = headB.next;
        }



        return null;

    }



}

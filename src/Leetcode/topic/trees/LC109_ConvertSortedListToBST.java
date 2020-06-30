package Leetcode.topic.trees;


import Leetcode.common.ListNode;
import Leetcode.common.TreeNode;

public class LC109_ConvertSortedListToBST {
    public static void main(String[] args) {
        LC109_ConvertSortedListToBST lc108 = new LC109_ConvertSortedListToBST();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        new LC109_ConvertSortedListToBST().sortedListToBST(one);
    }

    private static TreeNode contructTreeFromaArray(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = contructTreeFromaArray(nums, start, mid - 1);
        node.right = contructTreeFromaArray(nums, mid + 1, end);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = getMiddleOfList(head);

        TreeNode node = new TreeNode(mid.val);
// Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }



    private ListNode getMiddleOfList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        //System.out.println(slow.val);
        return slow;

    }


}


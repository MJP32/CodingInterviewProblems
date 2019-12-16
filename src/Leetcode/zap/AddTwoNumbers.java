package Leetcode.zap;

public class AddTwoNumbers {


    public static void main(String[] args) {
        //ListNode l1 = new ListNode(2).next=  new ListNode(4).next = new ListNode(3);

        //ListNode l2 = new ListNode(5).next= new ListNode(6).next = new ListNode(4);


        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode result = addTwoNumbers2(l1_1, l2_1);

        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();
        AddTwoNumbers add = new AddTwoNumbers();

        ListNode ans = add.addTwoNumbers(l1_1,l2_1);

        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }



    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode result = new ListNode(0);
        ListNode resultPointer = result;

        int sum = 0;
        int digit = 0;
        int carryover = 0;

        while(pointer1 != null || pointer2 != null || carryover != 0) {
            resultPointer.next = new ListNode(0);
            resultPointer = resultPointer.next;

            sum = 0;

            if(pointer1 != null) {
                sum = sum + pointer1.val;
                pointer1 = pointer1.next;
            }

            if(pointer2 != null) {
                sum = sum + pointer2.val;
                pointer2 = pointer2.next;
            }

            sum = sum + carryover;

            digit = sum % 10;
            carryover = sum/10;

            resultPointer.val = digit;
        }

        return result.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList, result = new ListNode(0);

        int carry = 0;
        int sum =0;
        int digit =0;
        while(l1 != null  || l2 != null || carry != 0){
            sum =0;
            sum += carry;

            if(l1 != null){
                sum += l1.val;
                l1= l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2= l2.next;
            }


            if(sum >= 10){

                digit = sum%10;
                carry = 1;
            }else{
                digit = sum;
                carry =0;


            }

            result.val = digit;
            result.next = new ListNode(0);

        }

        return result;



    }
}


 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
 }
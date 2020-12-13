package AlgoExpert.linkedlist;

public class MergeLinkedLists {
    public static void main(String[] args) {
        LinkedList l1= new LinkedList(2);
        LinkedList l2= new LinkedList(6);
        LinkedList l3= new LinkedList(7);
        LinkedList l4= new LinkedList(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;



        LinkedList l5= new LinkedList(1);
        LinkedList l6= new LinkedList(3);
        LinkedList l7= new LinkedList(5);
        LinkedList l8= new LinkedList(9);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;


        LinkedList merged = mergeLinkedLists(l1, l5);
        while(merged != null){
            System.out.println(merged.value);
            merged = merged.next;
        }


    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList mergedListHead = new LinkedList(-1);
        LinkedList mergedList = mergedListHead;

        while(headOne != null && headTwo !=null){
            if(headOne.value <= headTwo.value){
                mergedList.next = headOne;
                headOne = headOne.next;

            }
            else{
                mergedList.next = headTwo;
                headTwo = headTwo.next;
            }
            mergedList =mergedList.next;
        }

        //add remaining from list that is not null
        mergedList.next = headOne ==null? headTwo:headOne;
        mergedList.next = null;

        return mergedListHead.next;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

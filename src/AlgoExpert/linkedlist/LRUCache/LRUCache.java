package AlgoExpert.linkedlist.LRUCache;

public  class LRUCache {
    int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 1;
    }

//    public void insertKeyValuePair(String key, int value) {
//        // Write your code here.
//    }
//
//    public LRUResult getValueFromKey(String key) {
//        // Write your code here.
//        return new LRUResult();
//    }
//
//    public String getMostRecentKey() {
//        // Write your code here.
//
//
//    }

    static class DoublyLinkedList{
        DoublyLinkedListNode head = null;
        DoublyLinkedListNode tail = null;
        public void setHeadTo(DoublyLinkedListNode node){
            if (head == node) {
                return;
            }
            else if (head == null){
                head = node;
                tail = node;
            }
            else if(head == tail){
                tail.prev = node;
                head = node;
                head.next = tail;
            }
            else {
                if (tail == node) {
                   removeTail();
                }
                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }
        }
        public void removeTail(){
            if (tail == null){
                return;
            }
            if (tail == head) {
                head = null;
                tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;

        }

    }
    static class DoublyLinkedListNode{
        String key;
        int value;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode next = null;

        public DoublyLinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
        public void removeBindings(){
            if(prev != null){
                prev.next = next;
            }
            if (next != null) {
                next.prev = null;
            }
            prev = null;
            next = null;
        }
    }
    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

}



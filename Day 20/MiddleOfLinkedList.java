class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        int i = 1;
        ListNode middle = head;
        while(head!=null) {
            if(i%2 == 0) {
                middle = middle.next;
            }
            i++; head = head.next;
        }
        return middle;
    }
}
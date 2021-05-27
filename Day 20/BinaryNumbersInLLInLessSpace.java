public class BinaryNumbersInLLInLessSpace {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while(head!= null) {
            // shift left by 1 to make space
            sum = sum << 1;
            // add the current val
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
}
public class BinaryNumbersInLL {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int i = -1;
        while(head!= null) {
            list.add(head.val);
            i++;
            head = head.next;
        }
        int j =0;
        int sum = 0;
        while(i>-1) {
            int num = list.get(j);
            j++;
            if(num==1)
                sum += Math.pow(2,i);
            
            --i;
        }
        return sum;
    }
}
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQueue {
    public static void main(String ...arg) {
        int[] n = new int[]{5,3,7,2,4,8,6,0,10};
        //Arrays.sort(n);
        // when we pop or poll, the greatest is removed
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for(int i : n)
            pq.add(i);
        
        Iterator it = pq.iterator();
        while(it.hasNext()) {
            System.out.println(pq.poll());
        }
    }
}
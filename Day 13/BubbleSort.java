import java.util.*;

public class BubbleSort {

    public static void countSwaps(List<Integer> a) {
        int count_swaps = 0;
        Integer temp = 0;
        for(int i = 0 ; i<a.size()-1; i ++) {
            for(int j = 0; j<a.size()-1-i; j++) {
                if(a.get(j) > a.get(j+1)) {
                    //System.out.println("Swapping " + a.get(j) + " and " + a.get(j+1));
                    temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                    count_swaps++;
                }
            }
        }

        System.out.println("Array is sorted in "+  count_swaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        int size = a.size();
        System.out.println("Last Element: " + a.get(size-1));
    }
    public static void main(String ...arg) {
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(4);
        l.add(3);
        l.add(2);
        l.add(1);
        countSwaps(l);
    }
}
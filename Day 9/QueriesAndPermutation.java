import java.util.LinkedList;

public class QueriesAndPermutation {
    
    static int[] processQueries(int[] queries, int m) {
        int arr[] = new int[queries.length];
        int j = 0;
        LinkedList<Integer> p = new LinkedList<>();
        for(int i = 1; i<=m; i++) 
            p.add(i);

        for(int q : queries) {
            int index = p.indexOf(q);
            arr[j++] = index;
            p.remove(index);
            p.addFirst(q);
        }
        
        return arr;
    }

    public static void main(String ...arg) {
        int[] queries = new int[]{4,1,2,2};
        int m = 4;
        int[] ans = processQueries(queries,m);
        for(int n : ans)
            System.out.println(n);
    }
}
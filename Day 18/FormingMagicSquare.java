import java.util.ArrayList;

public class FormingMagicSquare {
            /*
             * Complete the 'formingMagicSquare' function below.
             *
             * The function is expected to return an INTEGER.
             * The function accepts 2D_INTEGER_ARRAY s as parameter.
             */
        
            static int formingMagicSquare(List<List<Integer>> s) {
                List<Integer> list = new ArrayList<>();
                
                list.add(s.get(0).get(0));
                list.add(s.get(0).get(1));
                list.add(s.get(0).get(2));

                list.add(s.get(1).get(2));
                list.add(s.get(2).get(2));

                list.add(s.get(2).get(1));
                list.add(s.get(2).get(0));
                list.add(s.get(1).get(0));

                int middle = s.get(1).get(1);


                List<Integer> a = new ArrayList<>();
                Collections.addAll(a,8,3,4,9,2,7,6,1);
                System.out.println(a);
                
                List<Integer> b = new ArrayList<>();
                Collections.addAll(b,4,9,2,7,6,1,8,3);

                List<Integer> c = new ArrayList<>();
                Collections.addAll(c,2,7,6,1,8,3,4,9);

                List<Integer> d = new ArrayList<>();
                Collections.addAll(d,6,1,8,3,4,9,2,7);

                List<Integer> e = new ArrayList<>();
                Collections.addAll(e,4,3,8,1,6,7,2,9);

                List<Integer> f = new ArrayList<>();
                Collections.addAll(f,8,1,6,7,2,9,4,3);

                List<Integer> g = new ArrayList<>();
                Collections.addAll(g,6,7,2,9,4,3,8,1);

                List<Integer> h = new ArrayList<>();
                Collections.addAll(g,2,9,4,3,8,1,7,6);

                List<List<Integer>> l = new ArrayList<>();
                l.add(a);
                l.add(b);
                l.add(c);
                l.add(d);
                
                l.add(e);
                l.add(f);
                l.add(g);
                l.add(h);
                
                int max = Integer.MAX_VALUE;
                for(int i = 0; i<8; i++) {
                    int sum = 0;
                    List<Integer> smol = l.get(i);
                    for(int j = 0; j < 8; j++) {
                        sum += Math.abs(smol.get(j) - list.get(j));
                        
                    }
                    sum += Math.abs(5 - s.get(1).get(1));
                    if (sum < max)
                        max = sum;
                }

                return max;
            }

    public static void main(String ...arg) {
        List<List<Integer>> s = new ArrayList<>();
        // make a 2D array - arr - using List<List<Integer>>
        formingMagicSquare(arr);
    }
}
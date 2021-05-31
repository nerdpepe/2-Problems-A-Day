import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizingContainers {
    static String organizingContainers(List<List<Integer>> container) {
        boolean possible = true;
        int sum;
        int[] cont = new int[container.size()];
        int[] balls = new int[container.size()];

        for (int i = 0; i < container.size(); i++) {
            sum = 0;
            for (int j = 0; j < container.get(i).size(); j++) {
                balls[j] += container.get(i).get(j);
                sum += container.get(i).get(j);
            }
            cont[i] = sum;
        }

        Arrays.sort(balls);
        Arrays.sort(cont);

        for (int j = container.size() - 1; j >= 0; j--) {
            if (balls[j] > cont[j]) {
                possible = false;
                break;
            }
        }

        if (possible)
            return "Possible";
        else
            return "Impossible";
    }

    public static void main(String... arg) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(1);
        b.add(2);
        List<Integer> c = new ArrayList<>();
        c.add(3);
        c.add(3);
        c.add(3);
        List<List<Integer>> containers = new ArrayList<>();
        containers.add(a);
        containers.add(b);
        containers.add(c);
        String ans = organizingContainers(containers);
        System.out.println(ans);
    }
}
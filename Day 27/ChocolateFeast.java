public class ChocolateFeast {
    /*
    n -> money
    c -> cost of each bar
    m -> no of wrappers required to buy a new bar
    */

    static int chocolateFeast(int n, int c, int m) {
        int eaten = 0;
        int justGot = 0;
        eaten += n/c;
        int wrappers = n/c; 
        while(wrappers >= m) {
            justGot = wrappers/m;
            eaten += justGot;
            wrappers = justGot + wrappers%m; 
        }
        return eaten;
    }

    public static void main(String... arg) {
        System.out.println(chocolateFeast(15, 3, 2));
    }
}
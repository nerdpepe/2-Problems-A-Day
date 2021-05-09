import java.io.*;
import java.util.*;

public class CheckPrimality {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            
            int isPrime = 1;
            int num  = sc.nextInt();
            
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num%i == 0){
                    isPrime = 0;
                    break;
                }
            }
            //check for the isPrime identifier and also whether the number is 1 or not
            if(isPrime == 0 || num == 1)
                System.out.println("Not prime");
            else
                System.out.println("Prime");
        }
    }
}
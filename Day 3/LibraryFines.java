import java.io.*;
import java.util.*;

public class LibraryFines {

    public static void main(String[] args) {
        int d1,m1,y1; //actual return date
        int d2,m2,y2; //due date
        
        Scanner sc = new Scanner(System.in);
        //return date
        d1 = sc.nextInt();
        m1 =sc.nextInt();
        y1 =sc.nextInt();
        
        //due date
        d2 =sc.nextInt();
        m2 =sc.nextInt();
        y2 =sc.nextInt();
        
        if(y1>y2)
            System.out.print(10000);
        else if (y1 == y2 ){
            if(m1>m2)
                System.out.print((m1-m2)*500);
            else {
                if(d1>d2)
                    System.out.print((d1-d2)*15);
                else
                    System.out.print(0);
            }
        }
        else 
          System.out.print(0);
    }
}
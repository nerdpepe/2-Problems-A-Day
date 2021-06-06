import java.util.Scanner;

public class OutputFormat {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                // String left justified in 15 characters
                // with 3 characters for int
                System.out.printf("%-15s%03d \n", s1,x);
            }
            System.out.println("================================");

    }
}




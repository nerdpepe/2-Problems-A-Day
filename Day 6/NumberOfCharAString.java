import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        int len = s.length();
        int no_of_a  = 0;
        long ans = 0;
        
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == 'a')
                no_of_a++;
        }
        
        if(n < len) {
            for(int j = 0; j<n; j++){
                if(s.charAt(j) == 'a')
                    ans++;
            }
        } else {
            ans = (n/len)*no_of_a;
            if(n%len != 0) {
             for(int k = 0; k<n%len; k++){
                if(s.charAt(k) == 'a')
                    ans++;
            }   
            }
        }
        
        return ans;
    }

}

public class NumberOfCharAString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
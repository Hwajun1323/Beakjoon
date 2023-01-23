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
    public static boolean twoN(long num) {
        return (num & (num - 1)) == 0;
    }
    
    public static long findLargestPowerOf2LessThanTheGivenNumber(long input) {
        long temp = input;
        if (input % 2 == 0) {
            temp = input - 1;
        }
        long power = (long) (Math.log(temp) / Math.log(2));
        long result = (long) Math.pow(2, power);
        return result;
    }

    public static String counterGame(long n) {
        int turn = 0;
        
        if(n==1) return "Richard";
        
        while(n!=1){
            if(twoN(n)){
                n = n /2;
            }else{
                n = n - findLargestPowerOf2LessThanTheGivenNumber(n);
            }
            turn++;
        }
        if(turn%2 == 0){
            return "Richard";
        }else{ 
            return "Louise";
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

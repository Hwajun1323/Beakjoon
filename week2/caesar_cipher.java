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
    public static String caesarCipher(String s, int k) {
        String result="";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if((ch >= 97 && ch <= 122)){
                ch = (char)(ch + k);
                while(ch > 122){
                    ch = (char)(ch - 122 + 96);
                }
            }else if((ch >= 65 && ch <= 90)){
                ch = (char)(ch + k);
                while(ch > 90){
                    ch = (char)(ch-90+64);
                }
            }
            result = result + ch;
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

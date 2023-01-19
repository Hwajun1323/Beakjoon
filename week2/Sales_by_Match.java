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
    public static int sockMerchant(int n, List<Integer> ar) {
        int cnt = 0;
        int max = ar.get(ar.size()-1);
        
        // initiate hashmap and save frequency of socks
        Map<Integer, Integer> pair = new HashMap<>();      
        for(int i =0 ; i<ar.size(); i++){
            pair.putIfAbsent(ar.get(i),0);
            pair.computeIfPresent(ar.get(i),(k,v)->v+1);
        }
        // save socks number in list
        List<Integer> list = new ArrayList<>();
        for(int i : pair.values()) list.add(i);
        
        for(int i=0 ; i<list.size(); i++){
            cnt += list.get(i)/2 ;
        }
        return cnt;
    }
        
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

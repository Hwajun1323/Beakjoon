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
    public static long countChar(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }
    
    public static String isValid(String s) {
        
        Map<Character, Integer> map = new HashMap<>();      
        for(char c: s.toCharArray()){
            map.putIfAbsent(c,0);
            map.computeIfPresent(c,(k,v)->v+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i : map.values()) list.add(i);
        
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int c : list){
            map2.putIfAbsent(c,0);
            map2.computeIfPresent(c, (k,v)->v+1);
        }
        
        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for(int i: map2.keySet()) keys.add(i);
        for(int i: map2.values()) values.add(i);
        
        if(values.size() == 1) return "YES";
        if(values.size() == 2){
            int tmp = 0;
            for(int i=0; i<values.size(); i++){
                if(values.get(i) == 1) tmp=keys.get(i);
            }
            if(values.contains(1) && Math.abs(keys.get(0) - keys.get(1)) == 1) return "YES";
            if(values.contains(1) && tmp == 1) return "YES";
        }
        return "NO";
    }    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

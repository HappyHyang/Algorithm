import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        StringBuilder output = new StringBuilder();
        output.append("a = ").append(a).append('\n');
        output.append("b = ").append(b).append('\n');
        System.out.print(output);
    }
}
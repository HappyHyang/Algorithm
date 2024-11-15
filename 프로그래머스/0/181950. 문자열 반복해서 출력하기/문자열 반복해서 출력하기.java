import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        StringBuilder output = new StringBuilder();
        while(n-- > 0) {
            output.append(str);
        }
        
        System.out.println(output);
    }
}
import java.io.*;

class Solution {
    public String solution(String my_string, int n){
        StringBuilder output = new StringBuilder();
        for(char ch : my_string.toCharArray()) {
            output.append(String.valueOf(ch).repeat(n));
        }
        return output.toString();
    }
}
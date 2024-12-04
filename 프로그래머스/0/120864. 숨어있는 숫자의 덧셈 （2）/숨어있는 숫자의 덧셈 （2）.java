import java.io.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder num = new StringBuilder();
        
        for(char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (num.length() != 0) {
                    answer += Integer.parseInt(num.toString());
                    num = new StringBuilder();
                }
            }
        }
        
        if (num.length() != 0) answer += Integer.parseInt(num.toString());
        
        return answer;
    }
}
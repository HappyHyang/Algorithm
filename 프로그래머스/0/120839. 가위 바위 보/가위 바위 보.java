import java.io.*;

class Solution {
    public String solution(String rsp) {        
        StringBuilder output = new StringBuilder();
        for (char ch : rsp.toCharArray()) {
            if (ch == '2') output.append('0');
            else if (ch == '0') output.append('5');
            else if (ch == '5') output.append('2');
        }
        return output.toString();
    }
}
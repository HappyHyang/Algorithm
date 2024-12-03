import java.io.*;

class Solution {
    public String solution(String polynomial) {
        int 일차항 = 0;
        int 상수항 = 0;
        
        for (String str : polynomial.split(" \\+ ")) {
            if (str.endsWith("x")) {
                if (str.equals("x")) {
                    일차항 += 1;
                } else {
                    일차항 += Integer.parseInt(str.replace("x", ""));
                }
            } else {
                상수항 += Integer.parseInt(str);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        if (일차항 > 0) {
            if (일차항 == 1) {
                answer.append("x");
            } else {
                answer.append(일차항).append("x");
            }
        }
        
        if (상수항 > 0) {
            if (answer.length() > 0) {
                answer.append(" + ");
            }
            answer.append(상수항);
        }
        
        if (answer.length() == 0) {
            answer.append("0");
        }
        
        return answer.toString();
    }
}
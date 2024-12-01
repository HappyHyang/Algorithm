import java.io.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int flag = 1;
        for(String str : my_string.split(" ")) {
            if (str.equals("+")) {
                flag = 1;
            } else if (str.equals("-")) {
                flag = -1;
            } else {
                answer += (flag * Integer.parseInt(str));
            }
        }
        return answer;
    }
}
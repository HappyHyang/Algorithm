import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        StringBuilder answer = new StringBuilder(new String(str));
        return answer.reverse().toString();
    }
}
import java.io.*;

class Solution {
    public String solution(String s) {
        int[] countAlphabet = new int[26];
        for (char c : s.toCharArray()) {
            countAlphabet[c - 'a']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (countAlphabet[i] == 1) answer.append((char) (i + 'a'));
        }
        return answer.toString();
    }
}
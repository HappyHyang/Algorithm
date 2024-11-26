import java.util.*;
import java.io.*;

class Solution {
    public long solution(String numbers) {
        Map<String, Character> alphabet = new HashMap<>();
        alphabet.put("zero", '0');
        alphabet.put("one", '1');
        alphabet.put("two", '2');
        alphabet.put("three", '3');
        alphabet.put("four", '4');
        alphabet.put("five", '5');
        alphabet.put("six", '6');
        alphabet.put("seven", '7');
        alphabet.put("eight", '8');
        alphabet.put("nine", '9');
        
        
        StringBuilder answer = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for (char ch : numbers.toCharArray()) {
            num.append(ch);
            if (alphabet.containsKey(num.toString())) {
                answer.append(alphabet.get(num.toString()));
                num.setLength(0);
            }
        }
        
        return Long.parseLong(answer.toString());
    }
}
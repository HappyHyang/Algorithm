import java.io.*;
import java.util.*;

class Solution {
    static final String[] morse = {".-","-...","-.-.","-..",".","..-.","--.",
                                   "....","..",".---","-.-",".-..","--","-.",
                                   "---",".--.","--.-",".-.","...","-","..-",
                                   "...-",".--","-..-","-.--","--.."};
    
    public String solution(String letter) {
        Map<String, Character> morseMap = new HashMap<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.",
                          "....","..",".---","-.-",".-..","--","-.",
                          "---",".--.","--.-",".-.","...","-","..-",
                          "...-",".--","-..-","-.--","--.."};
        for (int i = 0; i < morse.length; i++) {
            morseMap.put(morse[i], (char) ('a' + i));
        }
        
        StringBuilder output = new StringBuilder();
        for(String str : letter.split(" ")) {
            output.append(morseMap.get(str));
        }
        return output.toString();
    }
}
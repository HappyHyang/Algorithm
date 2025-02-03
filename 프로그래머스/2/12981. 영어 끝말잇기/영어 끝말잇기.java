import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String word = words[i];
            
            if(usedWords.contains(word) || prev.charAt(prev.length() - 1) != word.charAt(0)) 
                return new int[]{(i % n) + 1, (i / n) + 1};
            
            usedWords.add(word);
        }

        return new int[]{0, 0};
    }
}
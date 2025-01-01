class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipSet = new boolean[26];
        
        for (char c : skip.toCharArray()) {
            skipSet[c - 'a'] = true;
        }
        
        for (char c : s.toCharArray()) {
            int shift = index;
            char current = c;
            
            while (shift > 0) {
                current++;
                if (current > 'z') current = 'a';
                if (!skipSet[current - 'a']) shift--;
            }
            answer.append(current);
        }
        return answer.toString();
    }
}

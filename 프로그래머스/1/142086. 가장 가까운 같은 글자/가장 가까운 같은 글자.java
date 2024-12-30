import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] alphabetIdx = new int[26];
        Arrays.fill(alphabetIdx, -1);

        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int charIdx = currentChar - 'a';

            answer[i] = (alphabetIdx[charIdx] == -1) ? -1 : i - alphabetIdx[charIdx];
            alphabetIdx[charIdx] = i;
        }

        return answer;
    }
}

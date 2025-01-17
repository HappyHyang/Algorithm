import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < keymap.length; i++) {
            String keys = keymap[i];
            for (int j = 0; j < keys.length(); j++) {
                char c = keys.charAt(j);
                int index = c - 'A';
                if (alphabet[index] == -1 || alphabet[index] > j + 1) {
                    alphabet[index] = j + 1;
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String word = targets[i];
            int count = 0;
            boolean isPossible = true;

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int index = c - 'A';

                if (alphabet[index] == -1) {
                    isPossible = false;
                    break;
                } else {
                    count += alphabet[index];
                }
            }

            if (!isPossible) {
                answer[i] = -1;
            } else {
                answer[i] = count;
            }
        }

        return answer;
    }
}
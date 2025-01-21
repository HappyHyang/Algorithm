import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> mbti = new HashMap<>();
        for (char type : "RTCFJMAN".toCharArray()) {
            mbti.put(type, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i] - 4;
            char type = choice < 0 ? survey[i].charAt(0) : survey[i].charAt(1);
            mbti.put(type, mbti.get(type) + Math.abs(choice));
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(mbti.get('R') >= mbti.get('T') ? 'R' : 'T');
        answer.append(mbti.get('C') >= mbti.get('F') ? 'C' : 'F');
        answer.append(mbti.get('J') >= mbti.get('M') ? 'J' : 'M');
        answer.append(mbti.get('A') >= mbti.get('N') ? 'A' : 'N');
        return answer.toString();
    }
}
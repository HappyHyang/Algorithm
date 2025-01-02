class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = 0;
        int equal = 0;
        int notEqual = 0;

        for (char c : s.toCharArray()) {
            if (equal == 0 && notEqual == 0) {
                x = c;
                answer++;
            }

            if (c == x) {
                equal++;
            } else {
                notEqual++;
            }

            if (equal == notEqual) {
                equal = 0;
                notEqual = 0;
            }
        }
        return answer;
    }
}

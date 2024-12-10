class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n-- > 0) {
            answer++;
            while (answer % 3 == 0 || Integer.toString(answer).contains("3")) {
                answer++;
            }
        }
        return answer;
    }
}
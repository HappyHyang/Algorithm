class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() + n - 1) / n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = my_str.substring(i * n, Math.min((i * n) + n, my_str.length()));
        }
        return answer;
    }
}
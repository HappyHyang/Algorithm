class Solution {
    public String solution(String my_string) {
        boolean[] used = new boolean[128]; // ASCII 전체 범위 관리
        StringBuilder answer = new StringBuilder();
        
        for (char ch : my_string.toCharArray()) {
            if (!used[ch]) {
                used[ch] = true;
                answer.append(ch);
            }
        }
        return answer.toString();
    }
}

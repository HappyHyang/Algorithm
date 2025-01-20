class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPainted = 0;
        
        for (int start : section) {
            if (start > lastPainted) {
                answer++;
                lastPainted = start + m - 1;
            }
        }
        
        return answer;
    }
}

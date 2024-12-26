import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int request : d) {
            if (budget >= request) {
                budget -= request;
                answer++;
            } else break;
        }
        return answer;
    }
}
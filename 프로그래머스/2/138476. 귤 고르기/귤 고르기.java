import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> size = new HashMap<>();
        for (int i : tangerine) {
            size.put(i, size.getOrDefault(i, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(size.values());
        countList.sort(Collections.reverseOrder());

        int answer = 0;
        for (int count : countList) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }
}
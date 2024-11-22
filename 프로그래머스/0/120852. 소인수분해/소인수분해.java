import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();
        
        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                answer.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        
        return answer.stream()
                     .sorted()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
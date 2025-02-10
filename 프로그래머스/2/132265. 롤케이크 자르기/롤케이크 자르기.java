import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> older = new HashMap<>();
        Set<Integer> younger = new HashSet<>();
        for (int t : topping) {
            older.put(t, older.getOrDefault(t, 0) + 1);
        }

        int olderCnt = older.size();
        int youngerCnt = 0;
        
        int answer = 0;

        for (int t : topping) {
            older.put(t, older.get(t) - 1);
            
            if (older.get(t) == 0) {
                older.remove(t);
                olderCnt--;
            }

            if (younger.add(t)) youngerCnt++;
            
            if (olderCnt == youngerCnt) answer++;
        }

        return answer;
    }
}

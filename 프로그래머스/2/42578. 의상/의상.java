import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> info = new HashMap<>();
        for(String[] clothe : clothes) {
            info.put(clothe[1], info.getOrDefault(clothe[1], 0) + 1);
        }
        int answer = 1;
        for(Integer count : info.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    }
}
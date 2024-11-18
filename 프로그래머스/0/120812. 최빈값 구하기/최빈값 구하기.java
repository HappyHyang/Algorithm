import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countNum = new HashMap<>();
        for(int num : array) {
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }
        int maxCnt = 0;
        int maxValue = -1;
        
        for (int key : countNum.keySet()) {
            int currentCnt = countNum.get(key);
            if(currentCnt > maxCnt) {
                maxCnt = currentCnt;
                maxValue = key;
            } else if(currentCnt == maxCnt) {
                maxValue = -1;
            }
        }
        
        return maxValue;
    }
}
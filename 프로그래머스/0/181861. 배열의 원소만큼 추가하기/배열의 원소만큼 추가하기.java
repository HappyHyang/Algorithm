import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = Arrays.stream(arr).sum();
        
        int[] answer = new int[size];
        
        int idx = 0;
        for(int num : arr) {
            Arrays.fill(answer, idx, idx + num, num);
            idx += num;
        }
        
        return answer;
    }
}
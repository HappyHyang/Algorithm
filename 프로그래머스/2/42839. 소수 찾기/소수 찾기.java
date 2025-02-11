import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        
        char[] nums = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
        makeNum("", nums, visited, set);

        int answer = 0;
        for(int num : set) {
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    private void makeNum(String current, char[] nums, boolean[] visited, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(current + nums[i], nums, visited, set);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
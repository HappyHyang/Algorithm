import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--;
        
        int[] answer = new int[n];
        for (int i = n; i > 0; i--) {
            int index = (int) (k / factorial[i - 1]);
            answer[n - i] = nums.get(index);
            nums.remove(index);
            k %= factorial[i - 1];
        }

        return answer;
    }
}

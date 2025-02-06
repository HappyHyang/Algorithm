class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] nums = {4, 1, 2};
        
        while (n > 0) {
            int num = n % 3;
            answer.insert(0, nums[num]);
            n = (n - 1) / 3;
        }
        
        return answer.toString();
    }
}

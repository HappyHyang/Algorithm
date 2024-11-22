class Solution {
    public int solution(int n) {
        int answer = 1;
        int result = 1;
        
        while (result <= n) {
            result *= ++answer;
        }
        
        return answer - 1;
    }
}
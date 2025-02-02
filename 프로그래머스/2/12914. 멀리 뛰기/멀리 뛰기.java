class Solution {
    public long solution(int n) {
        if (n == 1) return 1;

        long a = 1, b = 2, temp;
        
        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 1234567;
            a = b;
            b = temp;
        }
        
        return b;
    }
}

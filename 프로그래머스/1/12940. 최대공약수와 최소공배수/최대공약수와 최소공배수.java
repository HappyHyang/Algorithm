class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, (n * m) / gcd};
    }
    
    private int gcd(int n, int m) {
        while(m != 0) {
            int temp = n;
            n = m;
            m = temp % m;
        }
        return n;
    }
}
class Solution {
    public int solution(int n) {
        return lcm(n, 6) / 6;
    }
    
    // 최대공약수
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 최소공배수
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
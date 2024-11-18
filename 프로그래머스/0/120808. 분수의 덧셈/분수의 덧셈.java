class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;
        int gcd = gcd(numer, denom);
        return new int[] {numer / gcd, denom / gcd};
    }
    
    public int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
class Solution {
    public int solution(int n) {
        int lastEven = (n % 2 == 0) ? n : n - 1;
        return (lastEven / 2 + 1) * (0 + lastEven) / 2;
    }
}
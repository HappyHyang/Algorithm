class Solution {
    public int solution(int price) {
        double discount = 1;
        if (price >= 500_000) {
            discount = 0.8;
        } else if (price >= 300_000) {
            discount = 0.9;
        } else if (price >= 100_000) {
            discount = 0.95;
        }
        return (int) (price * discount);
    }
}
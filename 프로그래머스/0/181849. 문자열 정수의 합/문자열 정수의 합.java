class Solution {
    public int solution(String num_str) {
        return num_str.chars().map(num -> num - '0').sum();
    }
}
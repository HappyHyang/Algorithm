import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling).filter(str -> str.matches("^(aya|ye|woo|ma)+$")).count();
    }
}
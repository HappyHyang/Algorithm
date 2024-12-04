import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);

        int min = sides[1] - sides[0] + 1; // 나머지 변이 가장 긴 변이 아닌 경우
        int max = sides[0] + sides[1] - 1; // 나머지 변이 가장 긴 변인 경우

        return max - min + 1;
    }
}
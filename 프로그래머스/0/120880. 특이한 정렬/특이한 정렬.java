import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    int distanceA = Math.abs(a - n);
                    int distanceB = Math.abs(b - n);

                    if (distanceA == distanceB) {
                       return b - a;
                    }
                    return distanceA - distanceB;
                })
                .mapToInt(i -> i)
                .toArray();
    }
}
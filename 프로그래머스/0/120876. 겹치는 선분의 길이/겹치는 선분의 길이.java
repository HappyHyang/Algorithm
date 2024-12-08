class Solution {
    public int solution(int[][] lines) {
        int[] whole = new int[200];
        for (int[] line : lines) {
            for (int i = line[0] + 100; i < line[1] + 100; i++) {
                whole[i]++;
            }
        }
        int answer = 0;
        for(int count : whole) {
            if (count >= 2) {
                answer++;
            }
        }
        return answer;
    }
}
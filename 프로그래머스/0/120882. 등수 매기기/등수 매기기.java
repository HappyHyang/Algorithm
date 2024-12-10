import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] totalScores = new int[n];
        int[] ranks = new int[n];
        
        for (int i = 0; i < n; i++) {
            totalScores[i] = score[i][0] + score[i][1];
        }
        
        Map<Integer, Integer> scoreToRank = new HashMap<>();
        int[] sortedScores = totalScores.clone();
        Arrays.sort(sortedScores);
        
        int rank = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (!scoreToRank.containsKey(sortedScores[i])) {
                scoreToRank.put(sortedScores[i], rank);
            }
            rank++;
        }
        
        for (int i = 0; i < n; i++) {
            ranks[i] = scoreToRank.get(totalScores[i]);
        }
        
        return ranks;
    }
}
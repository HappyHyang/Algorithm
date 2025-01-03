import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> fame = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            fame.add(score[i]);
            if (fame.size() > k) fame.poll();
            answer[i] = fame.peek();
        }

        return answer;
    }
}

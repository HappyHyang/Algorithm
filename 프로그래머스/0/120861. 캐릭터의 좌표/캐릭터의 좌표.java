class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        
        int width = board[0] / 2;
        int height = board[1] / 2;
        
        for (String input : keyinput) {
            switch (input) {
                case "left":
                    if (answer[0] - 1 >= -width) answer[0]--;
                    break;
                case "right":
                    if (answer[0] + 1 <= width) answer[0]++;
                    break;
                case "down":
                    if (answer[1] - 1 >= -height) answer[1]--;
                    break;
                case "up":
                    if (answer[1] + 1 <= height) answer[1]++;
                    break;
            }
        }
        return answer;
    }
}
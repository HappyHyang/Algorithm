class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            answer[i] = isCorrect(quiz[i]) ? "O" : "X";
        }
        return answer;
    }
    
    private boolean isCorrect(String str) {
        String[] formula = str.split(" ");
        int left = Integer.parseInt(formula[0]);
        int right = Integer.parseInt(formula[2]);
        int result = Integer.parseInt(formula[4]);
        return formula[1].equals("+") ? (left + right == result) : (left - right == result);
    }
}
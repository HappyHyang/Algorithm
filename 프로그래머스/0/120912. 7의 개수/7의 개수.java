class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int number : array) {
            String num = Integer.toString(number);
            for (char ch : num.toCharArray()) {
                if (ch == '7') answer++;
            }
        }
        return answer;
    }
}
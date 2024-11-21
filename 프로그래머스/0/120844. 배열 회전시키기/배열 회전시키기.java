class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int shift = direction.equals("right") ? 1 : -1;
        for (int i = 0; i < numbers.length; i++) {
            answer[(i + shift + numbers.length) % numbers.length] = numbers[i];
        }
        return answer;
    }
}
class Solution {
    public String[] solution(String[] names) {
        int size = (names.length + 4) / 5;
        String[] answer = new String[size];
        for(int i = 0; i < size ; i++) {
            answer[i] = names[5 * i];
        }
        return answer;
    }
}
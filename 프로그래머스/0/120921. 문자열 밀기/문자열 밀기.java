class Solution {
    public int solution(String A, String B) {
        if (!(A + A).contains(B)) return -1;
        
        String word = A;
        int answer = 0;
        
        while (!word.equals(B)) {
            word = word.charAt(word.length() - 1) + word.substring(0, word.length() - 1);
            answer++;
        }
        
        return answer;
    }
}
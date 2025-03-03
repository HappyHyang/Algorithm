/*
    각 자리의 가중치를 계산하고 각 모음을 0~4로 매핑하여, 위치를 계산한다.
    
    첫 번째 자리: 781 = (5^0) + (5^1) + (5^2) + (5^3) + (5^4)
    두 번째 자리: 156 = (5^0) + (5^1) + (5^2) + (5^3)
    세 번재 자리: 31 = (5^0) + (5^1) + (5^2)
    네 번째 자리: 6 = (5^0 + 5^1)
    다섯 번째 자리: 1 = (5^0)
*/

class Solution {
    public int solution(String word) {
        int[] weights = calcWeights(5);
        String alphabet = "AEIOU";
        
        int answer = 0;
        for(int i = 0; i < word.length(); i++) {
            answer += alphabet.indexOf(word.charAt(i)) * weights[i] + 1;
        }
        return answer;
    }
    
    private int[] calcWeights(int size) {
        int[] weights = new int[size];
        weights[size - 1] = 1;
        for(int i = size - 2; i >= 0; i--) {
            weights[i] = weights[i + 1] * 5 + 1; 
        }
        return weights;
    }
}
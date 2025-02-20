import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        while (!fits(wallet, bill)) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        return answer;
    }

    private boolean fits(int[] wallet, int[] bill) {
        return (wallet[0] >= bill[0] && wallet[1] >= bill[1]) ||
               (wallet[0] >= bill[1] && wallet[1] >= bill[0]);
    }
}

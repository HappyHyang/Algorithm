class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] reversedNum = new int[n];
        for(int i = 0; i < n; i++) {
            reversedNum[i] = num_list[n - i - 1];
        }
        return reversedNum;
    }
}
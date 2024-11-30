class Solution {
    public int[] solution(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                idx = i;
                maxValue = array[i];
            }
        }
        return new int[]{maxValue, idx};
    }
}
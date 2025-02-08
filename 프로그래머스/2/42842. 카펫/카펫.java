class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int width = total; width >= 1; width--) {
            if (total % width == 0) {
                int height = total / width;
                
                if (width >= height && (width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height}; 
                }
            }
        }
        
        return new int[]{};
    }
}

import java.util.*;

class Solution {
    static int width, height;

    public int solution(int[] mats, String[][] park) {
        width = park[0].length;
        height = park.length;

        int answer = -1;
        
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (canPlaceMat(mats[i], park)) return mats[i];
        }

        return answer;
    }

    private boolean canPlaceMat(int mat, String[][] park) {
        for (int row = 0; row <= height - mat; row++) {
            for (int col = 0; col <= width - mat; col++) {
                if (isValidPlacement(row, col, mat, park)) return true;
            }
        }
        return false;
    }

    private boolean isValidPlacement(int row, int col, int mat, String[][] park) {
        for (int r = row; r < row + mat; r++) {
            for (int c = col; c < col + mat; c++) {
                if (!park[r][c].equals("-1")) return false;
            }
        }
        return true;
    }
}

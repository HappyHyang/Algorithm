class Solution {
    private static final int[] DX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    private static final int[] DY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] isDanger = new boolean[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1) {
                    markDangerZones(board, isDanger, r, c, n);
                }
            }
        }
        
        int safeCount = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!isDanger[r][c] && board[r][c] == 0) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    private void markDangerZones(int[][] board, boolean[][] isDanger, int r, int c, int n) {
        for (int i = 0; i < DX.length; i++) {
            int nr = r + DX[i];
            int nc = c + DY[i];
            if (isIn(nr, nc, n)) {
                isDanger[nr][nc] = true;
            }
        }
    }

    private boolean isIn(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
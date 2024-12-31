class Solution {
    static int[] dog;
    static char[][] parkMap;
    
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        
        parkMap = new char[height][width];
        dog = new int[2];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                parkMap[row][col] = park[row].charAt(col);
                if (park[row].charAt(col) == 'S') {
                    dog[0] = row;
                    dog[1] = col;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            char direction = parts[0].charAt(0);
            int count = Integer.parseInt(parts[1]);
            move(direction, count);
        }
        return dog;
    }

    private void move(char direction, int count) {
        int[] delta = getDelta(direction);
        int nx = dog[0];
        int ny = dog[1];

        for (int step = 1; step <= count; step++) {
            nx += delta[0];
            ny += delta[1];

            if (!isIn(nx, ny) || parkMap[nx][ny] == 'X') {
                return;
            }
        }

        dog[0] = nx;
        dog[1] = ny;
    }

    private int[] getDelta(char direction) {
        switch (direction) {
            case 'N': return new int[]{-1, 0};
            case 'S': return new int[]{1, 0};
            case 'W': return new int[]{0, -1};
            case 'E': return new int[]{0, 1};
        }
        return new int[]{0, 0};
    }

    private boolean isIn(int row, int col) {
        return (0 <= row && row < parkMap.length) && (0 <= col && col < parkMap[0].length);
    }
}

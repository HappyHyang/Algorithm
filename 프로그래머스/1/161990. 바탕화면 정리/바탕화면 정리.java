class Solution {
    public int[] solution(String[] wallpaper) {
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        
        int lux = height;
        int luy = width;
        int rdx = 0;
        int rdy = 0;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (wallpaper[y].charAt(x) == '#') {
                    if (y < lux) lux = y;
                    if (x < luy) luy = x;
                    if (y > rdx) rdx = y;
                    if (x > rdy) rdy = x;
                }
            }
        }
        
        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}

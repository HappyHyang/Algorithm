import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();

        for (String[] time : book_time) {
            int start = strToMin(time[0]);
            int end = strToMin(time[1]) + 10;
            times.add(new int[]{start, 1});
            times.add(new int[]{end, -1});
        }

        times.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxRooms = 0;
        int currentRooms = 0;

        for (int[] time : times) {
            currentRooms += time[1];
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        return maxRooms;
    }

    private int strToMin(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

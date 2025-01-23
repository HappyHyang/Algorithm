class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int vl = timeToSec(video_len);
        int p = timeToSec(pos);
        int os = timeToSec(op_start);
        int oe = timeToSec(op_end);
        
        if (os <= p && p <= oe) {
                p = oe;
        }
        
        for (String command : commands) {
            switch (command) {
                case "next":
                    p += 10;
                    break;
                case "prev":
                    p -= 10;
                    break;
            }
            
            if (p < 0) {
                p = 0;
            } else if (p > vl) {
                p = vl;
            }
            
            if (os <= p && p <= oe) {
                p = oe;
            }
        }
        
        return secToTime(p);
    }
    
    private int timeToSec(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
    
    private String secToTime(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}

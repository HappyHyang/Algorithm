class Solution {
    public int solution(String t, String p) {
        int lenP = p.length();
        long numP = Long.parseLong(p);
        
        int answer = 0;
        for (int i = 0; i <= t.length() - lenP; i++) {
            if (Long.parseLong(t.substring(i, i + lenP)) <= numP) answer++;
        }
        
        return answer;
    }
}

class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            boolean exist = true;
            for (String alphabet : spell) {
                if (!word.contains(alphabet)) exist = false;
            }
            
            if (exist) return 1;
        }        
        return 2;
    }
}
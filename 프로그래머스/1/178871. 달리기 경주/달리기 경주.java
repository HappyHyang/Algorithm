import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameToRank = new HashMap<>();
        Map<Integer, String> rankToName = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            nameToRank.put(players[i], i);
            rankToName.put(i, players[i]);
        }
        
        for (String call : callings) {
            int currentRank = nameToRank.get(call);
            int prevRank = currentRank - 1;
            
            String prevPlayer = rankToName.get(prevRank);
            rankToName.put(prevRank, call);
            rankToName.put(currentRank, prevPlayer);
            
            nameToRank.put(call, prevRank);
            nameToRank.put(prevPlayer, currentRank);
        }
        
        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            answer[i] = rankToName.get(i);
        }
        return answer;
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> playersMap = new HashMap<>();
        Map<Integer, String> scoreMap = new HashMap<>();
        for(int i = 0; i<players.length;i++){
            playersMap.put(players[i], i);
            scoreMap.put(i, players[i]);
        }

        for(String calling : callings) {
            int idx = playersMap.get(calling);
            String player = scoreMap.get(idx - 1);

            playersMap.put(player, idx);
            playersMap.put(calling, idx - 1);

            scoreMap.put(idx, player);
            scoreMap.put(idx - 1, calling);
        }

        for(int i = 0; i < players.length; i++) {
            answer[i] = scoreMap.get(i);
        }

        return answer;
    }
}
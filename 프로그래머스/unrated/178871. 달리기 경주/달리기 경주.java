import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        Map<String, Integer> playersMap = new HashMap<>();

        for(int i = 0; i<players.length;i++){
            playersMap.put(players[i], i);

        }

        for(String calling : callings) {
            int idx = playersMap.get(calling);
            String player = answer[idx - 1];

            playersMap.put(player, idx);
            playersMap.put(calling, idx - 1);

            answer[idx] = player;
            answer[idx-1] = calling;
        }

        return answer;
    }
}
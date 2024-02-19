import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

            int cards1Idx = -1;
            int cards2Idx = -1;

            Map<String, Integer> cards1Map = new HashMap<>();
            Map<String, Integer> cards2Map = new HashMap<>();

            for (int i = 0; i < cards1.length; i++) {
                cards1Map.put(cards1[i], i);
            }

            for (int i = 0; i < cards2.length; i++) {
                cards2Map.put(cards2[i], i);
            }

            for (String str : goal) {
                if (cards1Map.containsKey(str)) {
                    int idx = cards1Map.get(str);
                    if (idx != cards1Idx + 1) {
                        return "No";
                    }
                    cards1Idx = idx;
                } else if (cards2Map.containsKey(str)) {
                    int idx = cards2Map.get(str);
                    if (idx != cards2Idx + 1) {
                        return "No";
                    }
                    cards2Idx = idx;
                } else {
                    return "No";
                }
            }

            return "Yes";
        }
}
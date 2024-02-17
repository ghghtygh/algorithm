import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            Map<Character, Integer> map = new HashMap<>();
            for (String keymapItem : keymap) {
                char[] charArray = keymapItem.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (!map.containsKey(charArray[i])) {
                        map.put(charArray[i], i + 1);
                        continue;
                    }

                    if (map.get(charArray[i]) - 1 > i) {
                        map.put(charArray[i], i + 1);
                    }
                }
            }

            for(int j = 0; j < targets.length; j++) {
                char[] charArray = targets[j].toCharArray();
                int res = 0;
                for (int i = 0; i < charArray.length; i++) {
                    if (!map.containsKey(charArray[i])) {
                        res = -1;
                        break;
                    }
                    res += map.get(charArray[i]);
                }
                answer[j] = res;
            }

            return answer;
        }
    }
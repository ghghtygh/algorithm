import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] solution(String s) {
            int size = s.length();
            int[] answer = new int[size];
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Character chr = chars[i];
                if (!map.containsKey(chr)) {
                    answer[i] = -1;
                    map.put(chr, i);
                } else {
                    answer[i] = i - map.get(chr);
                    map.put(chr, i);
                }
            }
            return answer;
        }
    }
import java.util.*;
class Solution {
        public String solution(String s, String skip, int index) {
            List<Character> characterList = new ArrayList<>();
            for (char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                if (skip.indexOf(ch) == -1) {
                    characterList.add(ch);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                int idx = characterList.indexOf(ch) + index;
                while (idx >= characterList.size()) {
                    idx -= characterList.size();
                }
                sb.append(characterList.get(idx));
            }
            return sb.toString();
        }
    }
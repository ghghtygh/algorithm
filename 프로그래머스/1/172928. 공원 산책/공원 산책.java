
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] solution(String[] park, String[] routes) {

            int[] answer = {0, 0};

            char[][] map = Arrays.stream(park)
                    .map(String::toCharArray)
                    .toArray(char[][]::new);

            for (int h = 0; h < map.length; h++) {
                for (int w = 0; w < map[0].length; w++) {
                    if (map[h][w] == 'S') {
                        answer[0] = h;
                        answer[1] = w;
                    }
                }
            }

            Map<String, int[]> routeMap = new HashMap<>();

            routeMap.put("E", new int[]{0, 1});
            routeMap.put("W", new int[]{0, -1});
            routeMap.put("N", new int[]{-1, 0});
            routeMap.put("S", new int[]{1, 0});

            for (String routeStr : routes) {
                String[] r = routeStr.split(" ");
                int[] route = routeMap.get(r[0]);
                int idx = Integer.parseInt(r[1]);
                if (isValid(map, answer, route, idx)) {
                    move(answer, route, idx);
                }
            }

            return answer;
        }

        public boolean isValid(char[][] map, int[] coord, int[] route, int idx) {
            int h = coord[0];
            int w = coord[1];
            for (int i = 0; i < idx; i++) {
                h += route[0];
                w += route[1];
                if (w < 0 || w >= map[0].length || h < 0 || h >= map.length) {
                    return false;
                }
                if (map[h][w] == 'X') {
                    return false;
                }
            }
            return true;
        }

        public void move(int[] coord, int[] route, int idx) {
            for (int i = 0; i < idx; i++) {
                coord[0] += route[0];
                coord[1] += route[1];
            }
        }
    }
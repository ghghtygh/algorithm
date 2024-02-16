    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;

            boolean[] wall = new boolean[n];

            for (int i : section) {
                wall[i - 1] = true;
            }

            for (int i = 0; i < n; i++) {

                if (wall[i]) {
                    answer += 1;
                    for (int j = 0; j < m && i + j < n; j++) {
                        wall[i + j] = false;
                    }
                    i = i + m - 1;
                }

            }

            return answer;
        }
    }
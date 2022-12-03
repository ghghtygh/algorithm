
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {

        boolean[] isVisit = new boolean[n];
        Queue<Integer> queue1 = new ArrayDeque<>();

        int answer = 0;
        for (int t = 0; t < n; t++) {

            if (!isVisit[t]) {
                answer += 1;
                queue1.add(t);
            }

            while (!queue1.isEmpty()) {
                int next = queue1.remove();
                isVisit[next] = true;
                for (int i = 0; i < n; i++) {
                    if (computers[next][i] == 1 && i != next && !isVisit[i]) {
                        queue1.add(i);
                    }
                }
            }
        }
        return answer;
    }
}

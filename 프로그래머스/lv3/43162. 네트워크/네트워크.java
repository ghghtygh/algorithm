
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {

		int answer = 0;
		boolean[] isVisit = new boolean[n];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {

			if (!isVisit[i]) {

				queue.add(i);
				answer += 1;

				// int prev = -1;
				while (!queue.isEmpty()) {

					int now = queue.poll();
					isVisit[now] = true;

					// if (prev >= 0) {
					// 	System.out.println("#" + answer + " : " + prev + " -> " + now + " 방문");
					// }

					for (int j = 0; j < computers[now].length; j++) {
						if (computers[j][now] == 1 && now != j && !isVisit[j]) {
							queue.add(j);
						}
					}
					// prev = now;
				}
			}

		}

		return answer;
	}
}

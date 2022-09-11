import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int[][] costs) {
		int answer = 0;
		boolean[] isVisited = new boolean[n];
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		int[][] costArr = new int[n][n];

		for (int[] cost : costs) {
			int a = cost[0];
			int b = cost[1];
			costArr[a][b] = cost[2];
			costArr[b][a] = cost[2];
		}

		queue.add(new int[] {0, 0});
		int count = 0;
		while (!queue.isEmpty()) {
			int[] nextArr = queue.poll();
			int idx = nextArr[0];
			int cost = nextArr[1];
			if (isVisited[idx]) {
				continue;
			}
			isVisited[idx] = true;
			answer += cost;
			// System.out.println("#" + count + ": " + idx + " 방문");
			for (int i = 0; i < n; i++) {
				if (costArr[idx][i] > 0 && !isVisited[i]) {
					queue.add(new int[] {i, costArr[idx][i]});
				}
			}
			count += 1;
			if (count >= n) {
				break;
			}
		}

		return answer;
	}
}
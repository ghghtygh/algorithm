
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edges) {

		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// for (int[] edge : edges) {
		// 	list[edge[0]].add(edge[1]);
		// 	list[edge[1]].add(edge[0]);
		// }

		for (int i = 0; i < edges.length; i++) {
			list[edges[i][0]].add(edges[i][1]);
			list[edges[i][1]].add(edges[i][0]);
		}

		Queue<Integer> queue1 = new ArrayDeque();
		queue1.add(1);

		int[] isVisit = new int[n + 1];
		isVisit[1] = 1;

		int max = Integer.MIN_VALUE;

		while (!queue1.isEmpty()) {
			int now = queue1.poll();
			// int nextCnt = isVisit[now] + 1;

			if (max < isVisit[now]) {
				max = isVisit[now];
			}

			// for (int i : list[now]) {
			for (int t = 0; t < list[now].size(); t++) {
				int i = list[now].get(t);
				// if (isVisit[i] > 0 && isVisit[i] < nextCnt) {
				if (isVisit[i] > 0) {
					continue;
				}

				queue1.add(i);
				isVisit[i] = isVisit[now] + 1;
			}
		}

		// Arrays.sort(isVisit);
		// int answer = 1;
		// for (int i = n - 1; i > 0; i--) {
		// 	if (isVisit[i] < isVisit[n]) {
		// 		break;
		// 	}
		// 	answer += 1;
		// }

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (isVisit[i] == max) {
				answer += 1;
			}
		}
		return answer;
	}
}
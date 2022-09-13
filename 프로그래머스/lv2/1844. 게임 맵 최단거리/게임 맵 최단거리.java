
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int solution(int[][] maps) {
		int answer = 0;
		int[][] visited = new int[maps.length][maps[0].length];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		visited[0][0] = 1;

		int[][] directs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while (!queue.isEmpty()) {

			int[] cur = queue.poll();
			int n = cur[0];
			int m = cur[1];

			for (int[] direct : directs) {
				int x = n + direct[0];
				int y = m + direct[1];

				if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
					continue;
				}
				if (visited[x][y] == 0 && maps[x][y] == 1) {
					visited[x][y] = visited[n][m] + 1;
					queue.add(new int[] {x, y});
				}

			}

		}
		answer = visited[maps.length - 1][maps[0].length - 1];
		return answer == 0 ? -1 : answer;
	}
	
}
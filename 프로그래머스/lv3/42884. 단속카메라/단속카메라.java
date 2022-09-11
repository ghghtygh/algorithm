import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


class Solution {
    
    public int solution(int[][] routes) {

		Arrays.sort(routes, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

		int answer = 0;

		Queue<int[]> queue1 = new ArrayDeque<>(Arrays.asList(routes));
		int nextTime = Integer.MIN_VALUE;
		while (!queue1.isEmpty()) {

			int[] tmp1 = queue1.poll();

			if (nextTime < tmp1[0]) { // 새로시작
				nextTime = tmp1[1];
				answer += 1;
			} else if (nextTime >= tmp1[1]) { // 설치 예정시간보다 나가는 시간이 더 빠름
				nextTime = tmp1[1];
			}

		}

		return answer;
	}
}
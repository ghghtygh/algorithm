
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

	public int solution(int[] scoville, int K) {
		Queue<Integer> queue = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

		int answer = 0;
		while (queue.peek() < K) {

			if (queue.size() <= 1) {
				return -1;
			}
			int food1 = queue.poll();
			int food2 = queue.poll();
			queue.add(food1 + (food2 * 2));
			answer++;

		}
		return answer;
	}
}
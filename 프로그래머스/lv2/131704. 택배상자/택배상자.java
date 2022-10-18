
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[] order) {

		Deque<Integer> stack = new ArrayDeque<>();

		int answer = 0;
		int idx = 1;
		stack.add(idx++);

		for (int i = 0; i < order.length; i++) {

			while (stack.isEmpty() || stack.peekLast() < order[i]) {
				stack.addLast(idx++);
			}
			
			if (stack.pollLast() == order[i]) {
				answer += 1;
			} else {
				break;
			}

		}

		return answer;
	}
}
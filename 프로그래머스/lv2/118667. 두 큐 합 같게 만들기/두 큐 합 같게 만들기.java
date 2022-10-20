import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();

		long sum1 = 0;
		long sum2 = 0;

		for (int i = 0; i < queue1.length; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];

			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}
	

		int N = (queue1.length * 4);

		for (int i = 0; i < N; i++) {
			if (sum1 == sum2) {
				return i;
			}

			if (sum1 > sum2) {
				int tmp = q1.poll();
				q2.add(tmp);
				sum1 -= tmp;
				sum2 += tmp;
			} else {
				int tmp = q2.poll();
				q1.add(tmp);
				sum1 += tmp;
				sum2 -= tmp;
			}
		}

		return -1;
	}
}
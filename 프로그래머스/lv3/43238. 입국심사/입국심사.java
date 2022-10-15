import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

class Solution {
    
    public long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);

		long l = 0;
		long r = (long)n * times[times.length - 1];

		while (l <= r) {
			long mid = (l + r) / 2;
			AtomicLong sum = new AtomicLong();
			Arrays.stream(times).forEach(value -> sum.addAndGet(mid / value));

			if (n <= sum.get()) {
				r = mid - 1;
				answer = mid;
			} else {
				l = mid + 1;
			}

		}
		return answer;
	}
}
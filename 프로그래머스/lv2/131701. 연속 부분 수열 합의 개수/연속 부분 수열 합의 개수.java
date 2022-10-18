import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {

		int N = elements.length;
		int[] arr = new int[(N * 2) - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = elements[i % N];
		}
		int[] dp = new int[arr.length + 1];

		dp[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			dp[i + 1] = dp[i] + arr[i];
		}

		Set<Integer> set = new HashSet<>();
		set.add(dp[N]);
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < dp.length; j++) {
				if (i + j >= dp.length) {
					continue;
				}
				set.add(dp[i + j] - dp[j]);
			}
		}

		return set.size();
	}
}
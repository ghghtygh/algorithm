class Solution {
	public int solution(int n) {

		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[2] = 3;
		// dp[6] = 11 * 3 + (3 + 1) * 2 = 33 + 8 = 41

		for (int i = 2; i <= n; i += 2) {
			long tmp = dp[i - 2] * 3L;
			for (int j = i - 4; j >= 0; j -= 2) {
				tmp += dp[j] * 2L;
			}
			dp[i] = (int)(tmp % 1_000_000_007);
		}

		return dp[n];
	}
}
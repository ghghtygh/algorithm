class Solution {

		public int[] fibArr = new int[100_001];
		public int divNum = 1_234_567;

		public int solution(int n) {
			return dp(n);
		}

		public int dp(int n) {

			if (n <= 2) {
				return 1;
			}

			if (fibArr[n] == 0) {
				fibArr[n] = (dp(n - 2) % divNum + dp(n - 1) % divNum) % divNum;
			}
			return fibArr[n];
		}
	}
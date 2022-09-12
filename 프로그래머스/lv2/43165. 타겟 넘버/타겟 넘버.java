class Solution {

	int answer = 0;
	int target = 0;
	int[] numbers;
	boolean[] isVisit;

	public int solution(int[] numbers, int target) {
		this.answer = 0;
		this.target = target;
		this.numbers = numbers;
		this.isVisit = new boolean[numbers.length];

		int res = 0;
		for (int i : numbers) {
			res += i;
		}
		dfs(-1, 0, res);
		return answer;
	}

	public void dfs(int idx, int depth, int res) {

		if (depth >= numbers.length) {
			return;
		}

		if (depth > 0) {
			res = res - (2 * numbers[idx]);

			if (res == target) {
				answer += 1;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!isVisit[i] && i > idx) {
				isVisit[i] = true;
				dfs(i, depth + 1, res);
				isVisit[i] = false;
			}
		}
	}
}
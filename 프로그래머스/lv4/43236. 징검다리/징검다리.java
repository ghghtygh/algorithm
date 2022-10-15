import java.util.Arrays;

class Solution {
    
    public int solution(int distance, int[] rocks, int n) {

		Arrays.sort(rocks);

		int answer = 0;
		int l = 0;
		int r = distance;

		while (l <= r) {
			int mid = (r + l) / 2;
			int removeCnt = getRemoveCnt(distance, rocks, mid);

			if (removeCnt <= n) {
				l = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				r = mid - 1;
			}
		}
		return answer;
	}

	public int getRemoveCnt(int distance, int[] rocks, int mid) {

		int removeCnt = 0;
		int prev = 0;

		for (int i = 0; i < rocks.length; i++) {

			if (rocks[i] - prev < mid) {
				removeCnt += 1;
			} else {
				prev = rocks[i];
			}

		}

		if (distance - prev < mid) {
			removeCnt += 1;
		}

		return removeCnt;
	}
}

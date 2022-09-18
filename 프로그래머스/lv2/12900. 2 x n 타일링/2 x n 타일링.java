class Solution {

	int[] cntArr;

	public int solution(int n) {
		cntArr = new int[n + 1];

		cntArr[0] = 1;
		cntArr[1] = 1;
		cntArr[2] = 2;

		int divInt = 1_000_000_007;
		for (int i = 1; i <= n; i++) {
			if (cntArr[i] == 0) {
				cntArr[i] = (((cntArr[i - 2] * 2) % divInt) + ((cntArr[i - 3] * 1) % divInt)) % divInt;
			}
		}

		return cntArr[n];
	}

}
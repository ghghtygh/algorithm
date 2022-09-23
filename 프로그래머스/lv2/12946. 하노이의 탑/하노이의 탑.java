
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
		List<int[]> list = new ArrayList<>();
		recur(n, 1, 2, 3, list);
		return list.toArray(new int[list.size()][2]);
	}

	public void recur(int idx, int from, int tmp, int to, List<int[]> list) {

		if (idx == 1) {
			list.add(new int[] {from, to});
			return;
		}

		// idx-1개를 임시로 옮김
		recur(idx - 1, from, to, tmp, list);

		list.add(new int[] {from, to});

		// idx-1개를 임시 -> 목적지로 이동
		recur(idx - 1, tmp, from, to, list);

	}
}
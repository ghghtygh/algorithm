import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


class Solution {
    
    public int solution(int[] cards) {
		boolean[][] isVisit = new boolean[cards.length + 1][cards.length + 1];

		int maxIdx = -1;
		int maxNum = 0;
		int maxNum2 = 0;

		for (int i = 1; i <= cards.length; i++) {
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(i);
			int tmp = 0;
			while (!queue.isEmpty()) {
				int n = queue.poll();
				tmp += 1;
				if (!isVisit[cards[n - 1]][i]) {
					queue.add(cards[n - 1]);
					isVisit[cards[n - 1]][i] = true;
				}
			}
			if (tmp > maxNum) {
				maxNum = tmp;
				maxIdx = i;
			}
		}

		for (int i = 1; i <= cards.length; i++) {
			if (isVisit[i][maxIdx] || maxIdx == i) {
				continue;
			}

			boolean[] isVisitTmp = Arrays.copyOf(isVisit[maxIdx], cards.length + 1);
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(i);
			int tmp = 0;
			while (!queue.isEmpty()) {
				int n = queue.poll();
				tmp += 1;
				if (!isVisitTmp[cards[n - 1]]) {
					queue.add(cards[n - 1]);
					isVisitTmp[cards[n - 1]] = true;
				}
			}
			if (tmp > maxNum2) {
				maxNum2 = tmp;
			}
		}

		if (maxNum <= 0 || maxNum2 <= 0) {
			return 0;
		} else {
			return (maxNum - 1) * (maxNum2 - 1);
		}
	}
}

/*
1 2 3 4 5 6 7 8
8 6 3 7 2 5 1 4

1 -> 8 -> 4 -> 7 -> 1 == 4
2 -> 6 -> 5 -> 2 == 3


1 2 3 4 5 6 7 8
8 6 3 7 2 5 1 4


4 * 4 = 16
3 * 5 = 15

1 2 3 4
2 3 4 1


1 2 3 4 5 6 7 8
2 3 4 5 1 7 8 6

1 -> 2 -> 3 -> 4 -> 5 -> 1 == 5
6 -> 7 -> 8 -> 6 == 3
>> 15

1 2 3 4 5 1
6 7 8 6
----------------
1 2 3 5 1 == 4
4 5 == 1
6 7 8 6 == 3
-----------------
4 5 1 2 3 4 == 5
6 7 8 6 == 3
>> 15
------------------


*/
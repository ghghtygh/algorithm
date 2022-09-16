import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {

		char[][] boardArr = new char[n][m];
		for (int y = 0; y < m; y++) {
			boardArr[m - y - 1] = board[y].toCharArray();
		}

		// for (int y = m - 1; y >= 0; y--) {
		// 	for (int x = 0; x < n; x++) {
		// 		System.out.print(boardArr[y][x]);
		// 	}
		// 	System.out.println();
		// }

		int answer = 0;
		while (true) {
			Set<Map<String, Integer>> setArr = new HashSet<>();
			for (int x = 0; x < n - 1; x++) {
				for (int y = 0; y < m - 1; y++) {
					char[] tmpArr = new char[] {
						boardArr[y][x], boardArr[y + 1][x], boardArr[y][x + 1], boardArr[y + 1][x + 1]
					};
					if (isGetScore(tmpArr)) {
						Map<String, Integer> map = new HashMap<>();
						map.put("x", x);
						map.put("y", y);
						setArr.add(map);
						map = new HashMap<>();
						map.put("x", x + 1);
						map.put("y", y);
						setArr.add(map);
						map = new HashMap<>();
						map.put("x", x);
						map.put("y", y + 1);
						setArr.add(map);
						map = new HashMap<>();
						map.put("x", x + 1);
						map.put("y", y + 1);
						setArr.add(map);
					}
				}
			}

			// 지울 것 없으면 break
			if (setArr.isEmpty()) {
				break;
			}

			List<Map<String, Integer>> list = new ArrayList(setArr);
			Collections.sort(list,
				(o1, o2) -> o1.get("x") == o2.get("x") ? o1.get("y") - o2.get("y") : o1.get("x") - o2.get("x"));

			for (Map<String, Integer> tmp : list) {
				if (boardArr[tmp.get("y")][tmp.get("x")] != 'X') {
					answer += 1;
					boardArr[tmp.get("y")][tmp.get("x")] = 'X';
				}
			}

			// for (int y = m - 1; y >= 0; y--) {
			// 	for (int x = 0; x < n; x++) {
			// 		System.out.print(boardArr[y][x]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("====");

			sortBoardArr(boardArr, n, m);

			// for (int y = m - 1; y >= 0; y--) {
			// 	for (int x = 0; x < n; x++) {
			// 		System.out.print(boardArr[y][x]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("====");

		}

		return answer;
	}

	public boolean isGetScore(char[] chars) {
		if (chars[0] == 'X') {
			return false;
		}
		for (int i = 1; i < 4; i++) {
			if (chars[i] == 'X' || chars[0] != chars[i]) {
				return false;
			}
		}
		return true;
	}

	public void sortBoardArr(char[][] boardArr, int n, int m) {
		for (int x = 0; x < n; x++) {
			for (int y = m - 1; y >= 0; y--) {
				if (boardArr[y][x] == 'X') {
					continue;
				}
				for (int yy = y - 1; yy >= 0; yy--) {
					if (boardArr[yy][x] == 'X' && boardArr[yy + 1][x] != 'X') {
						boardArr[yy][x] = boardArr[yy + 1][x];
						boardArr[yy + 1][x] = 'X';
						y += 1;
						break;
					}
				}
			}
		}
	}
}
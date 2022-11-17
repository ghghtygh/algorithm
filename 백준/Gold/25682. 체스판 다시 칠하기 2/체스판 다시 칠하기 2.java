
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] booleans1 = new boolean[N + 1][M + 1];
			boolean[][] booleans2 = new boolean[N + 1][M + 1];

			int[][] arr1 = new int[N + 1][M + 1];
			int[][] arr2 = new int[N + 1][M + 1];
			/*
			BBB BWB WBW
			BBB WBW BWB
			BBB BWB WBW

			ㅌ ㅇ ㅌ
			ㅌ ㅌ ㅌ
			ㅌ ㅌ ㅇ

			1 1 2
			2 3

			ㅇ ㅇ ㅇ
			ㅇ ㅇ ㅌ

			0 + 0 + 1

			ㅇ ㅌ ㅇ
			ㅇ ㅌ ㅌ

			1 + 1 + 1 == 3

			ㅌ ㅌ ㅇ
			ㅌ ㅌ ㅌ

			2 + 2 + 1 == 5

			ㅌ ㅌ ㅇ
			ㅌ ㅌ ㅌ
			ㅌ ㅌ ㅌ


			0/1
			 */
			char[] chars = {'B', 'W'};

			for (int i = 1; i <= N; i++) {
				String line = br.readLine();
				for (int j = 1; j <= M; j++) {
					char ch = line.charAt(j - 1);

					arr1[i][j] = arr1[i][j - 1] + arr1[i - 1][j] - arr1[i - 1][j - 1];
					arr2[i][j] = arr2[i][j - 1] + arr2[i - 1][j] - arr2[i - 1][j - 1];

					if (ch == chars[(i + j) % 2]) {
						arr2[i][j] += 1;
					} else {
						arr1[i][j] += 1;
					}

				}
			}

			// System.out.println("===");
			//
			// for (int i = 1; i <= N; i++) {
			// 	for (int j = 1; j <= M; j++) {
			// 		System.out.printf("%2d ", arr1[i][j]);
			// 	}
			// 	System.out.println();
			// }

			/*
			6 - 2 - 2 + == 2
			 */

			int result = Integer.MAX_VALUE;
			// 바꿔야하는 최소값 찾기
			for (int i = K; i <= N; i++) {
				for (int j = K; j <= M; j++) {
					int tmp1 = arr1[i][j] - arr1[i - K][j] - arr1[i][j - K] + arr1[i - K][j - K];
					int tmp2 = arr2[i][j] - arr2[i - K][j] - arr2[i][j - K] + arr2[i - K][j - K];
					result = Math.min(result, Math.min(tmp1, tmp2));
				}
			}

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

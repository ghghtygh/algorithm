

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int N = Integer.parseInt(br.readLine());

			int[] A = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			StringBuffer sb = new StringBuffer(N);
			for (int i = 0; i < M; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				int r = N;
				int l = 0;
				int res = 0;
				int mid;

				while (l < r) {
					mid = (r + l) / 2;
					if (A[mid] == tmp) {
						res = 1;
						r = l;
					} else if (A[mid] < tmp) {
						l = mid + 1;
					} else {
						r = mid;
					}
				}
				sb.append(res).append("\n");
			}
			System.out.println(sb);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

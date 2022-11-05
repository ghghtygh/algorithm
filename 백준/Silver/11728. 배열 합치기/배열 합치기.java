

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

			int[] A = new int[N];
			int[] B = new int[M];
			int[] C = new int[N + M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			int i = 0;
			int j = 0;
			int k = 0;

			while (i < N && j < M) {
				if (A[i] <= B[j]) {
					C[k++] = A[i++];
				} else {
					C[k++] = B[j++];
				}
			}

			while (i < N) {
				C[k++] = A[i++];
			}

			while (j < M) {
				C[k++] = B[j++];
			}

			StringBuilder sb = new StringBuilder();

			for (i = 0; i < C.length; i++) {
				sb.append(C[i]).append(" ");
			}
			System.out.println(sb.toString().trim());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

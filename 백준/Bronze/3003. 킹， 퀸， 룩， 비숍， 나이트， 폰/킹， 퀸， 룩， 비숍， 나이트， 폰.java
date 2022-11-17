
import static java.util.stream.IntStream.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] CHESS_PEACE = {1, 1, 2, 2, 2, 8};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringBuffer sb = new StringBuffer();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			range(0, CHESS_PEACE.length)
				.forEach(i -> sb.append(CHESS_PEACE[i] - Integer.parseInt(st.nextToken())).append(" "));
			
			System.out.println(sb);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

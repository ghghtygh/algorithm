
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int[] COIN_ARR = {500, 100, 50, 10, 5, 1};

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int money = Integer.parseInt(br.readLine());

			int change = 1000 - money;
			int result = 0;
			for (int i = 0; i < COIN_ARR.length; i++) {
				if (change == 0) {
					break;
				}
				result += change / COIN_ARR[i];
				change %= COIN_ARR[i];
			}

			System.out.println(result);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

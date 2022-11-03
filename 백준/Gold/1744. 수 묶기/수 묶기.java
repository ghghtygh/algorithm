
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int N = Integer.parseInt(br.readLine());
			List<Integer> plusList = new ArrayList<>();
			List<Integer> minusList = new ArrayList<>();

			int zeroCnt = 0;

			while (N-- > 0) {
				int tmp = Integer.parseInt(br.readLine());
				if (tmp == 0) {
					zeroCnt += 1;
				}
				if (tmp < 0) {
					minusList.add(tmp);
				} else {
					plusList.add(tmp);
				}
			}

			Collections.sort(plusList, (o1, o2) -> o2 - o1);
			Collections.sort(minusList);

			// 0이 존재하고 묶이지 않는 음수가 있는 경우 -> 0으로 만듬
			if (minusList.size() % 2 == 1 && zeroCnt > 0) {
				minusList.remove(minusList.size() - 1);
				plusList.remove(plusList.size() - 1);
			}

			int answer = 0;
			for (int i = 0; i < plusList.size(); i++) {

				int t1 = plusList.remove(i);

				if (t1 <= 1) {
					answer += t1;
					i--;
					continue;
				}

				int t2 = 1;
				if (plusList.size() >= 1) {
					t2 = plusList.get(i);
				}

				if (t2 <= 1) {
					answer += t1;
					i--;
					continue;
				}

				plusList.remove(i);
				i--;
				answer += t1 * t2;
			}

			for (int i = 0; i < minusList.size(); i++) {
				int t1 = minusList.remove(i);
				int t2 = 1;
				if (minusList.size() >= 1) {
					t2 = minusList.remove(i);
				}
				i--;
				answer += t1 * t2;
			}

			System.out.println(answer);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

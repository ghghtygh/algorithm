
import java.util.HashMap;
import java.util.Map;

class Solution {
    
	public int solution(String[] want, int[] number, String[] discount) {

		int answer = 0;
		Map<String, Integer> wantMap = new HashMap<>();
		Map<String, Integer> discountMap = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}

		for (int i = discount.length - 1; i >= 0; i--) {

			int dCnt = discountMap.getOrDefault(discount[i], 0) + 1;
			discountMap.put(discount[i], dCnt);

			if (i < discount.length - 10 && discountMap.containsKey(discount[i + 10])) {
				dCnt = discountMap.get(discount[i + 10]) - 1;
				discountMap.put(discount[i + 10], dCnt);
			}

			if (isContainsWant(wantMap, discountMap)) {
				answer += 1;
			}
		}

		return answer;
	}

	public boolean isContainsWant(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {

		for (String wantKey : wantMap.keySet()) {

			if (!discountMap.containsKey(wantKey)) {
				return false;
			}

			int dCnt = discountMap.getOrDefault(wantKey, 0);
			int wCnt = wantMap.get(wantKey);

			if (dCnt < wCnt) {
				return false;
			}

		}
		return true;
	}
}
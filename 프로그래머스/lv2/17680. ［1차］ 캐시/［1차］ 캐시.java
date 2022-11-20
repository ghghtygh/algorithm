import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		Set<String> cacheSet = new LinkedHashSet<>();

		if (cacheSize <= 0) {
			return cities.length * 5;
		}

		for (String city : cities) {
			city = city.toLowerCase();
			if (cacheSet.contains(city)) {
				answer += 1;
                cacheSet.remove(city);
			} else {
				answer += 5;
				if (cacheSize == cacheSet.size()) {
					for (String s : cacheSet) {
						cacheSet.remove(s);
						break;
					}
				}
			}
			cacheSet.add(city);

		}
		return answer;
	}
}

import static java.util.regex.Pattern.*;

import java.util.Arrays;

class Solution {
    private final String[] pronouns = {"aya", "ye", "woo", "ma"};

	public int solution(String[] babbling) {
		return (int)Arrays.stream(babbling).filter(this::isCheck).count();
	}

	public boolean isCheck(String str) {
		for (String pStr : pronouns) {
			if (compile("(" + pStr + ")\\1").matcher(str).find()) {
				break;
			}
			str = str.replaceAll(pStr, "");
		}
		return str.length() == 0;
	}
}
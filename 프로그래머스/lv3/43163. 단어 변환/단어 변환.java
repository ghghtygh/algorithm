
class Solution {
    
    
	int answer;
	boolean[] isVisited;
	String[] words;
	int strLen;
	String target;

	public int solution(String begin, String target, String[] words) {

		this.target = target;
		this.strLen = begin.length();
		this.words = words;
		this.isVisited = new boolean[words.length];
		this.answer = 51;

		dfs(begin, 0, 0);

		return answer >= 51 ? 0 : answer;
	}

	public void dfs(String now, int depth, int count) {

		if (now.equals(target)) {
			answer = Math.min(answer, count);
		}

		for (int i = 0; i < words.length; i++) {
			if (!isVisited[i] && isDiffALetter(now, words[i])) {
				isVisited[i] = true;
				dfs(words[i], depth + 1, count + 1);
				isVisited[i] = false;
			}
		}
	}

	public boolean isDiffALetter(String str1, String str2) {
		int diff = 0;
		for (int i = 0; i < strLen; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diff += 1;
				if (diff > 1) {
					break;
				}
			}
		}
		return diff == 1 ? true : false;
	}
    
}

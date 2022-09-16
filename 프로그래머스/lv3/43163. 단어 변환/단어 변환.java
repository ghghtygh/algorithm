
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    
    public int solution(String begin, String target, String[] words) {

		boolean[] isVisited = new boolean[words.length];
		boolean[] isFinished = new boolean[begin.length()];

		for (int i = 0; i < isFinished.length; i++) {
			if (begin.charAt(i) == target.charAt(i)) {
				isFinished[i] = true;
			}
		}

		Queue<String> queue = new ArrayDeque<>();
		queue.add(begin);

		int answer = 0;
		while (!queue.isEmpty()) {
			queue.remove();
			loop1:
			for (int i = 0; i < words.length; i++) {
				if (!isVisited[i]) {
					int diff = 0;
					int finIdx = -1;
					for (int j = 0; j < isFinished.length; j++) {

						if (words[i].charAt(j) == target.charAt(j)) {
							if (!isFinished[j]) {
								diff += 1;
								finIdx = j;
							}
						} else if (isFinished[j]) {
							isVisited[i] = true;
							continue loop1;
						}
					}
					if (diff == 1) {
						isFinished[finIdx] = true;
						queue.add(words[i]);
						answer += 1;
						// System.out.printf("#%d >> %s\n", answer, words[i]);
						if (words[i].equals(target)) {
							return answer;
						}
					}
				}
			}
		}
		return 0;
	}
}
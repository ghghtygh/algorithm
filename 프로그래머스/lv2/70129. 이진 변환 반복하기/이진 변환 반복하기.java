class Solution {
    
    public int[] solution(String s) {
		
		int[] answer = {0, 0};
		
		while (s.length() > 1) {

			answer[0] += 1;

			int len = s.length();

			s = s.replaceAll("0", "");

			answer[1] += len - s.length();

			s = Integer.toBinaryString(s.length());
		}

		return answer;
	}
    
}
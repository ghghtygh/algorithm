class Solution {
    public String solution(String s) {

		String[] strArr = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String str : strArr) {
			char[] charArr = str.toCharArray();
			if (charArr.length == 0) {
				sb.append(" ");
				continue;
			}
			sb.append((char)(charArr[0] >= 97 ? charArr[0] - 32 : charArr[0]));
			for (int i = 1; i < charArr.length; i++) {
				sb.append((char)(charArr[i] < 97 ? charArr[i] + 32 : charArr[i]));
			}
			sb.append(" ");
		}
		return sb.substring(0, s.length());
	}
}
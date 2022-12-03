class Solution {
    public int solution(String s) {

        int[][] arr = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i][i] = 1;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                arr[i - 1][i] = 2;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && arr[j + 1][i - 1] > 0) {
                    arr[j][i] = arr[j + 1][i - 1] + 2;
                }
            }
        }

        int answer = 1;
        for (int[] ar : arr) {
            for (int a : ar) {
                answer = Math.max(a, answer);
            }
        }
        return answer;
    }
}
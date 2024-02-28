    class Solution {
        public int solution(String s) {
            int answer = 0;
            int diff = 0;
            int same = 0;
            int c = s.charAt(0);
            for (char ch : s.toCharArray()) {

                if (same == diff) {
                    answer += 1;
                    c = ch;
                }

                if (ch == c) {
                    same++;
                } else {
                    diff++;
                }


            }
            System.out.println();

            return answer;
        }
    }
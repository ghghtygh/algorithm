class Solution {
       public int solution(int[] arr) {

            int answer = 2;
            
            for (int input : arr) {
                answer = findLcm(answer, input);
            }

            return answer;
        }
        
        public int findLcm(int input1, int input2) {
            if (input1 == 0 || input2 == 0) {
                throw new IllegalArgumentException();
            }
            return input1 * input2 / findGcd(input1, input2);
        }
        
        public int findGcd(int input1, int input2) {
            if (input1 == 0 || input2 == 0) {
                throw new IllegalArgumentException();
            }
            while (input1 > 0) {
                int tmp = input1;
                input1 = input2 % input1;
                input2 = tmp;
            }
            
            return input2;
        }
}
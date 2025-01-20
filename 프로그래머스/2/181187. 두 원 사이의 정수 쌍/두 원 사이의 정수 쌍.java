class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        double r1Pow = Math.pow(r1, 2);
        double r2Pow = Math.pow(r2, 2);

        for (int y = 1; y <= r2; y++) {
            double yPow = Math.pow(y, 2);
            answer += (int) Math.sqrt(r2Pow - yPow) - (int) Math.ceil(Math.sqrt(r1Pow - yPow)) + 1;
        }
        
        answer *= 4;
        return answer;
    }
}
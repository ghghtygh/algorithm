class Solution {
    public long solution(int k, int d) {

        long answer = 0L;
        
        double powD = Math.pow(d, 2);

        for (int i = 0; i <= d; i += k) {
            // i^2 + j^2 = d^2
            long maxX = (long)Math.sqrt(powD - Math.pow(i, 2));
            answer += (maxX / k) + 1;
            
        }

        return answer;
    }
}
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int w1 = Math.max(wallet[0], wallet[1]);
        int h1 = Math.min(wallet[0], wallet[1]);

        int w2 = Math.max(bill[0], bill[1]);
        int h2 = Math.min(bill[0], bill[1]);

        while (w2 > w1 || h2 > h1) {
            int n = w2 / 2;
            w2 = Math.max(n, h2);
            h2 = Math.min(n, h2);
            answer += 1;
        }

        return answer;
    }
}
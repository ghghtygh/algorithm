class Solution {

    
    public static boolean[] isVisit;
    public static int[] numbers;
    public static int result;
    public static int target;

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;
        this.isVisit = new boolean[numbers.length];
        this.result = 0;

        dfs(0, 0, 0);

        return this.result;
    }

    public static void dfs(int idx, int depth, int sum) {
        int tmp = sum;
        for (int i = 0; i < numbers.length; i++) {
            if (!isVisit[i]) {
                tmp -= numbers[i];
            }
        }
        if (target == tmp) {
            result += 1;
        }

        if (depth >= numbers.length) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!isVisit[i] && i >= idx) {
                isVisit[i] = true;
                dfs(i, depth + 1, sum + numbers[i]);
                isVisit[i] = false;
            }
        }
    }
    
    
}
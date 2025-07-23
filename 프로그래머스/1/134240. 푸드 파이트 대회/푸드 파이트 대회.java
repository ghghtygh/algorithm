class Solution {
    public String solution(int[] food) {

        int totalCount = 0;

        int[] foodCounts = new int[food.length];
        for (int i = 1; i < food.length; i++) {
            foodCounts[i] = (food[i] / 2);
            totalCount += foodCounts[i];
        }

        char[] answer = new char[(totalCount * 2) + 1];

        int leftIdx = 0;
        int rightIdx = answer.length - 1;

        for(int i = 1; i < food.length; i++){
            char fd = (char) (i + '0');
            for(int j = 0; j < foodCounts[i]; j++){
                answer[leftIdx++] = fd;
                answer[rightIdx--] = fd;
            }
        }
        answer[leftIdx] = '0';
        return String.valueOf(answer);
    }
}
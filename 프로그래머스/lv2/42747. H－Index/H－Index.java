import java.util.Arrays;

class Solution {
    
    public int solution(int[] citations) {

        int result = 0;

        Arrays.sort(citations);

        int n = citations.length;

        for (int i = n - 1; i >= 0; i--) {
            int h = citations[i];
            while (h > 0) {
                if (n - i >= h) {
                    break;
                }
                h--;
            }

            if (h > result) {
                result = h;
            }
        }
        return result;
    }
}
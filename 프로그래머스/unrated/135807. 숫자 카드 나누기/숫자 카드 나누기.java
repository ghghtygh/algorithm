import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gdc1 = findGDC(arrayA[0], arrayA);
        int result1 = findResult(gdc1, arrayB);
        
        int gdc2 = findGDC(arrayB[0], arrayB);
        int result2 = findResult(gdc2, arrayA);

        return Math.max(result1, result2);
    }

    public int findResult(int gdc, int[] arr) {

        while (gdc > 1) {
            boolean isValid = true;
            for (int i : arr) {
                if (i % gdc == 0) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return gdc;
            }

            for (int i = 2; i <= gdc; i++) {
                if (gdc % i == 0) {
                    gdc /= i;
                    break;
                }
            }
        }

        return 0;
    }

    public int findGDC(int startNum, int[] arr) {
        while (startNum > 1) {
            boolean isValid = true;
            for (int i : arr) {
                if (i % startNum != 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return startNum;
            }
            startNum--;
        }

        return 0;
    }
}
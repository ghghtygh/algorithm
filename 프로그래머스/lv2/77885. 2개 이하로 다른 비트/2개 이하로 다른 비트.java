class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getNextBitNumber(numbers[i]);
        }
        return answer;
    }

    public static long getNextBitNumber(long number) {

        if (number % 2 == 0) {
            return number + 1;
        }

        String binaryStr = Long.toBinaryString(number);
        String afterBinaryStr;

        int lastIdxZero = binaryStr.lastIndexOf("0");

        if (lastIdxZero <= 0) {
            afterBinaryStr = "10" + binaryStr.substring(1);
        } else {
            afterBinaryStr = binaryStr.substring(0, lastIdxZero) + "10" + binaryStr.substring(lastIdxZero + 2);
        }

        // System.out.println("binaryStr = " + binaryStr);
        // System.out.println("afterBinaryStr = " + afterBinaryStr);
        return Long.parseLong(afterBinaryStr, 2);
    }
}
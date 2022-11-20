import java.util.Arrays;

class Solution {
    
    public int solution(int n) {
        
		int bitCnt = Integer.bitCount(n);

		for (int i = n + 1; i <= 1000000; i++) {
			if (Integer.bitCount(i) == bitCnt) {
				return i;
			}
		}
        return -1;
	}
}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<IndexWithNumber> stack = new ArrayDeque<>();
            stack.push(new IndexWithNumber(0, numbers[0]));
            
            for (int i = 1; i < numbers.length; i++) {
                while (!stack.isEmpty() && stack.peek().getNumber() < numbers[i]) {
                    IndexWithNumber indexWithNumber = stack.pop();
                    numbers[indexWithNumber.getIndex()] = numbers[i];
                }
                stack.push(new IndexWithNumber(i, numbers[i]));
            }

            while(!stack.isEmpty()) {
                IndexWithNumber indexWithNumber = stack.pop();
                numbers[indexWithNumber.getIndex()] = -1;
            }

            return numbers;
    }
    
    public static class IndexWithNumber {
            private Integer index;
            private Integer number;

            public IndexWithNumber(Integer index, Integer number) {
                this.index = index;
                this.number = number;
            }

            public Integer getIndex() {
                return index;
            }

            public Integer getNumber() {
                return number;
            }
        }
}
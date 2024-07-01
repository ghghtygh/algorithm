import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Stream;

class Solution {
        public int[] solution(int[] sequence, int k) {

            int i1 = 0;
            int i2 = 0;

            int sum = sequence[0];

            SortedSet<Node> nodeSortedSet = new TreeSet<>(Comparator.comparingInt(Node::getLength).thenComparingInt(Node::getI1));

            while (true) {
                if (sum == k) {
                    nodeSortedSet.add(new Node(i1, i2, i2 - i1));
                }
                if (i1 == sequence.length && i2 == sequence.length) {
                    break;
                }
                if(sum <= k && i2 < sequence.length) {
                    i2++;
                    if(i2 < sequence.length) {
                        sum += sequence[i2];
                    }
                } else {
                    if(i1 < sequence.length) {
                        sum -= sequence[i1];
                    }
                    i1++;
                }
            }

            Node first = nodeSortedSet.first();

            return new int[]{first.getI1(), first.getI2()};
        }

        public static class Node {
            private int i1;
            private int i2;

            private int length;

            public Node(int i1, int i2, int length) {
                this.i1 = i1;
                this.i2 = i2;
                this.length = length;
            }

            public int getI1() {
                return i1;
            }

            public int getI2() {
                return i2;
            }

            public int getLength() {
                return length;
            }
        }
    }
import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] solution(int[][] edges) {
            int[] answer = new int[4];
            answer[0] = -1;
            Map<Integer, PortCount> nodeMap = new HashMap<>();

            for (int[] edge : edges) {
                PortCount portCount1 = nodeMap.getOrDefault(edge[0], new PortCount());
                portCount1.increaseOutput();
                nodeMap.put(edge[0], portCount1);

                PortCount portCount2 = nodeMap.getOrDefault(edge[1], new PortCount());
                portCount2.increaseInput();
                nodeMap.put(edge[1], portCount2);
            }

            for (Map.Entry<Integer, PortCount> portCountEntry : nodeMap.entrySet()) {
                PortCount portCount = portCountEntry.getValue();
                if (portCount.getOutput() > 1 && portCount.getInput() == 0) {
                    answer[0] = portCountEntry.getKey();
                } else if (portCount.getOutput() == 0 && portCount.getInput() > 0) {
                    answer[2] += 1;
                } else if (portCount.getOutput() > 1 && portCount.getInput() > 1) {
                    answer[3] += 1;
                }
            }

            answer[1] = nodeMap.get(answer[0]).getOutput() - answer[2] - answer[3];

            return answer;
        }

        public static class PortCount {
            private int input;
            private int output;
            public int getInput() {
                return input;
            }

            public void increaseInput() {
                this.input += 1;
            }

            public int getOutput() {
                return output;
            }

            public void increaseOutput() {
                this.output += 1;
            }
        }

    }
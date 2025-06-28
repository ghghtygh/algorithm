class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        int[] endTimes = new int[schedules.length];
        
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            int endTime = (hour * 100 + minute + 10);
            if (endTime % 100 >= 60) {
                endTime += 40;
            }
            endTimes[i] = endTime;
        }

        for (int i = 0; i < timelogs.length; i++) {
            boolean notLate = true;
            for (int j = 0; j < 7; j++) {
                
                int orderDate = (startday + j - 1) % 7;
                
                if (orderDate == 5 || orderDate == 6) {
                    continue;
                }

                if (timelogs[i][j] > endTimes[i]) {
                    notLate = false;
                    break;
                }
            }

            if (notLate) {
                answer += 1;
            }
        }
        
        return answer;
    }
}
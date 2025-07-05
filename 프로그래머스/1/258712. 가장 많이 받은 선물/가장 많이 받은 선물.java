import java.util.List;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        List<String> friendList = List.of(friends);
        int[][] giftMap = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        for (String gift : gifts) {

            String[] splited = gift.split(" ");
            String from = splited[0];
            String to = splited[1];

            int fromIdx = friendList.indexOf(from);
            int toIdx = friendList.indexOf(to);

            giftScore[fromIdx] += 1;
            giftScore[toIdx] -= 1;
            giftMap[fromIdx][toIdx] += 1;
        }

        for (int[] tmp : giftMap) {
            for (int i : tmp) {
                System.out.printf("%3d", i);
            }
            System.out.println();
        }

        for (int i = 0; i < friends.length; i++) {
            int score = 0;
            for (int j = 0; j < friends.length; j++) {
                if (giftMap[i][j] == giftMap[j][i] && giftScore[i] > giftScore[j]) {
                    score += 1;
                } else if (giftMap[i][j] > giftMap[j][i]) {
                    score += 1;
                }
            }
            answer = Math.max(answer, score);
        }

        return answer;
    }
}
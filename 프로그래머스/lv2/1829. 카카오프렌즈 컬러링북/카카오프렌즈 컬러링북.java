import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    
    public int m;
    public int n;
    public int[][] picture;
    public boolean[][] isVisit;
    public int[] xMove = new int[] {-1, 1, 0, 0};
    public int[] yMove = new int[] {0, 0, -1, 1};

    public int numberOfArea;
    public int maxSizeOfOneArea;
    public int tmpSizeOfOneArea;

    public int[] solution(int m, int n, int[][] picture) {
        this.numberOfArea = 0;
        this.maxSizeOfOneArea = 0;

        this.isVisit = new boolean[m][n];
        this.picture = picture;
        this.m = m;
        this.n = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (picture[i][j] > 0 && isVisit[i][j] == false) {
                    tmpSizeOfOneArea = 0;
                    dfs(i, j, picture[i][j]);
                    numberOfArea += 1;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpSizeOfOneArea);
                }

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void dfs(int x, int y, int c) {

        isVisit[x][y] = true;
        tmpSizeOfOneArea++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (nextY < 0 || nextY >= n) {
                continue;
            }

            if (nextX < 0 || nextX >= m) {
                continue;
            }

            if (picture[nextX][nextY] == c && isVisit[nextX][nextY] == false) {
                dfs(nextX, nextY, c);
            }
        }
    }
}
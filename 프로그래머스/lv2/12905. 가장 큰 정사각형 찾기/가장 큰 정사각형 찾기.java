class Solution {
          public int solution(int[][] board) {

        int result = 0;

        if (board.length <= 1 || board[0].length <= 1) {
            return 1;
        }

        for (int i = 1; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {

                if (board[j][i] > 0) {
                    board[j][i] = Math.min(Math.min(board[j - 1][i - 1], board[j - 1][i]), board[j][i - 1]) + 1;
                }
                result = Math.max(result, board[j][i]);
            }
        }
        /*
        0 0 1 1
        1 1 1 1

        0 0 1 2
        1 1 1 2
         */

        return result * result;
    }

}
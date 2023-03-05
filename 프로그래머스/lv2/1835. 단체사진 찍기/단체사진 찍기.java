import java.util.Arrays;

class Solution {
    
    private char[] friends = "ACFJMNRT".toCharArray();
    private String[] dataArr;
    private int count;

    public int solution(int n, String[] data) {

        this.dataArr = data;
        this.count = 0;

        for (int i = 0; i < friends.length; i++) {

            char[] res = new char[friends.length];
            boolean[] isVisited = new boolean[friends.length];

            isVisited[i] = true;
            res[0] = friends[i];
            dfs(0, res, isVisited);
        }

        return count;
    }

    public void dfs(int depth, char[] res, boolean[] isVisited) {
        if (depth >= this.friends.length - 1) {
            if (isValid(String.valueOf(res))) {
                count += 1;
            }
            return;
        }
        for (int i = 0; i < this.friends.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                res[depth + 1] = this.friends[i];
                dfs(depth + 1, res, Arrays.copyOf(isVisited, this.friends.length));
                isVisited[i] = false;
            }
        }
    }

    public boolean isValid(String res) {

        boolean result = false;
        for (String data : dataArr) {
            int i1 = res.indexOf(data.charAt(0));
            int i2 = res.indexOf(data.charAt(2));
            int d = Math.abs(i1 - i2) - 1;
            int sw = data.charAt(4) - '0';

            switch (data.charAt(3)) {
                case '<':
                    result = (d < sw);
                    break;
                case '>':
                    result = (d > sw);
                    break;
                case '=':
                    result = (d == sw);
                    break;
                default:
                    return false;
            }

            if (!result) {
                return false;
            }
        }
        return result;
    }

}
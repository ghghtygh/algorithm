import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        int[] t = new int[4];

        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            /*
            2,2 3,4
             */

            for(int j = 0; j < 4; j++){
                t[j] = Integer.parseInt(st.nextToken());
            }
            sb.append((dp[t[2]][t[3]] - dp[t[2]][t[1] - 1] - dp[t[0] - 1][t[3]] + dp[t[0] - 1][t[1] - 1]) + "\n");
        }
        System.out.print(sb);
    }
}

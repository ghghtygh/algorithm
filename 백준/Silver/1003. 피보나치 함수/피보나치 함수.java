import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long[][] arr = new Long[2][41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        arr[0][0] = 1L;
        arr[0][1] = 0L;

        arr[1][0] = 0L;
        arr[1][1] = 1L;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp(0, N)).append(" ").append(dp(1, N)).append("\n");
        }
        System.out.print(sb);
    }
    static long dp(int n1, int n2) {
        if (arr[n1][n2] == null) {
            arr[n1][n2] = dp(n1, n2 - 1) + dp(n1, n2 - 2);
        }
        return arr[n1][n2];
    }
}

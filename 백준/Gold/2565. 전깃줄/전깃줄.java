import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] P;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전기줄 개수
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][2];
        P = new int[N+1];
        StringTokenizer st;

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 1; i <= N; i++){
            P[i] = 1;
            for(int j = 1; j < i; j++){
                int tmp = P[j] + 1;
                if (tmp > P[i] && arr[i][1] > arr[j][1]) {
                    P[i] = tmp;
                }
            }
            //System.out.printf("P[%d] = %d\n",i, P[i]);
        }
        Arrays.sort(P);
        System.out.println(N-P[N]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr; // 물건 가치의 최대 누적합
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[K+1];
        weights = new int[N+1];
        values = new int[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = K; j - weights[i] >= 0; j--){
                arr[j] = Math.max(arr[j], arr[j - weights[i]] + values[i]);
            }
        }
        System.out.println(arr[K]);

    }
}

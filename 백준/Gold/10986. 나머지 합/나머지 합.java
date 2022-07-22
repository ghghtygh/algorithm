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

        int[] arr = new int[N + 1];
        int[] cnt = new int[M];
        long res = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = N; i > 0; i--) {
            int inp = Integer.parseInt(st.nextToken());

            if(i != N){
                arr[i] = (arr[i + 1] + inp) % M;
            } else {
                arr[i] = inp % M;
            }

            res += cnt[arr[i]];
            cnt[arr[i]] += 1;

            if(arr[i] == 0){
                res += 1;
            }
        }


        System.out.println(res);
    }
}

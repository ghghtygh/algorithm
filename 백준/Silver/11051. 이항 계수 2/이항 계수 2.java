import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[][] arr;

    public Main(int N, int K){
        arr = new int[N+1][K+1];
    }
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Main main = new Main(N, K);
            System.out.println(main.getBn(N, K));
        } catch (IOException e){

        }
    }

    public int getBn(int N, int K){
        if(K == 0){
            return 1;
        }
        if(N == K) {
            return 1;
        }

        if(arr[N][K] > 0){
            return arr[N][K];
        }

        arr[N][K] = (getBn(N-1, K-1) + getBn(N-1, K)) % 10007;
        return arr[N][K];
    }
}

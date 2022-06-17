import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] P;
    public Main(int N, int M){
        P = new int[N+1][M+1];
    }
    public int getCnt(int N, int M){
        if(N == M){
            return 1;
        }
        if(M <= 1){
            return 1;
        }
        if(N == 1) {
            return M;
        }
        if(P[N][M] > 0){
            return P[N][M];
        }
        P[N][M] = getCnt(N-1, M-1) + getCnt(N, M-1);

        return P[N][M];
    }
    public static void main(String[] args){
        Main main = new Main(30, 30);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int n = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            StringTokenizer st;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                sb.append(main.getCnt(N,M)).append("\n");
            }
            System.out.print(sb);
        } catch(IOException e){

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int M;
    int N;

    Boolean[] arr;
    StringBuffer sb;

    public Main(int N, int M){
        sb = new StringBuffer();
        this.N = N;
        this.M = M;
        this.arr = new Boolean[N+1];
    }
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Main main = new Main(N, M);
            for(int i = 1; i <= N; i++){
                main.startF(i, 1, null);
            }

            System.out.print(main.sb);
        } catch(IOException e){ }
    }

    public void startF(int idx, int depth, int[] visits){

        if(depth == 1) {
            Arrays.fill(arr, false);
            visits = new int[M+1];
        }

        arr[idx] = true;
        visits[depth] = idx;

        if(depth == M){
            for(int i = 1; i < M; i++){
                sb.append(visits[i]).append(" ");
            }
            sb.append(visits[M]).append("\n");
            return;
        }

        for(int i = idx+1; i <= N; i++){
            if(!arr[i]){
                arr[i] = true;
                startF(i, depth+1, visits);
                arr[i] = false;
            }
        }

    }
}

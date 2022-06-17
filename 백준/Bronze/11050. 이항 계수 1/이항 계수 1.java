import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            System.out.println(getBn(N, K));
        } catch (IOException e){

        }
    }

    public static int getBn(int N, int K){
        if(K == 0){
            return 1;
        }
        if(N == K) {
            return 1;
        }
        return getBn(N-1, K-1) + getBn(N-1, K);
    }
}

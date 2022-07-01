import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] inpArr = new int[N+1];
        int[] resArr = new int[N+1];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 1; i <= N; i++){
            inpArr[i] = Integer.parseInt(st.nextToken());
            resArr[i] = resArr[i-1] + inpArr[i];
            if(i >= K){
                resArr[i] = resArr[i] - inpArr[i-K];
            }
        }

        int max = resArr[K];
        for(int i = K; i <= N; i++) {
            if(resArr[i] > max){
                max = resArr[i];
            }
        }
        System.out.println(max);
    }
}

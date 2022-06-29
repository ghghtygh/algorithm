import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr; // 누적합 저장
    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++){
                // 누적합 저장
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }

            StringBuffer sb = new StringBuffer();
            for(int idx = 0; idx < M; idx++){
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                sb.append(sumAccArr(i, j)).append("\n");
            }

            System.out.print(sb);
        } catch(IOException e){

        }
    }
    public static int sumAccArr(int i, int j){
        return arr[j] - arr[i-1];
    }
}

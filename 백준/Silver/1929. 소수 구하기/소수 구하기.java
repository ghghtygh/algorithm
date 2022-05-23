import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            Boolean[] arr = new Boolean[N+1];
            Arrays.fill(arr, true);
            arr[1] = false;
            int rep = N/2;
            for(int i = 2; i <= rep; i++){
                for(int j = N / i; j >= i; j--){
                    int n = i*j;
                    if(arr[n] == true){
                        arr[n] = false;
                    }
                }
            }

            for(int i = M; i <= N; i++){
                if(arr[i] == true){
                    System.out.println(i);
                }
            }
        } catch (IOException e){

        }
    }

}

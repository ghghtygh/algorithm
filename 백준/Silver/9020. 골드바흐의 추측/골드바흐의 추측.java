import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] arr;
    public static void main(String[] args){

        arr = new int[10000 + 1];
        Arrays.fill(arr, 1);
        arr[1] = 0;
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            int T = Integer.parseInt(br.readLine());

            for(int t = 0; t < T; t++){
                solution(Integer.parseInt(br.readLine()));
            }
        } catch (IOException e){

        }
    }

    public static void solution(int n){

        int sqrt = (int) Math.sqrt(n);

        for(int i = 2; i <= sqrt; i++){
            if(arr[i] != 0) {
                for (int j = i + i; j <= n; j += i) {
                    arr[j] = 0;
                }
            }
        }

        /*
        10 -> 5
        11 -> 5
        4 6
        16 8
         */
        for(int i = n/2; i >= 2; i--){
           if( arr[n - i] == 1 && arr[i] == 1){
               System.out.printf("%d %d\n", i, (n-i));
               break;
           }
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] arr;
    public static void main(String[] args){

        arr = new int[(123456 * 2) + 1];

        Arrays.fill(arr, 1);
        arr[1] = 0;

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            int n;
            while((n = Integer.parseInt(br.readLine())) != 0){
                System.out.println(solution(n));
            }
        } catch (IOException e){

        }
    }

    public static int solution(int n){
        int n2 = n * 2;
        int cnt = 0;

        int sqrt = (int)Math.sqrt(n2);

        for(int i = 2; i <= sqrt; i++){
            if(arr[i] != 0){
                for(int j = i+i; j <= n2; j += i){
                    arr[j] = 0;
                }
            }
        }

        for(int i = n+1; i<=n2; i++){
            if(arr[i] != 0){
                cnt += 1;
            }
        }

        return cnt;
    }
}

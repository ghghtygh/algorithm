
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] arr;
    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            /*
                4 ->                                      (20) (10) (4)
                3 -> 1 1+1+1+2  1+1+1+1+ 1+1+2+2+2+3     1+1+1+1+1+1+1+1+1+1 (10) +2+2+2+2+2+2 (6) +3+3+3 (3)+4 (1)
                2 -> 1 1+1+2    1+1+1+2+2+3             1+1+1+1+2+2+2+3+3+4
                1 -> 1 1+2      1+2+3                   1+2+3+4
                0 -> 1   2     3
                                  1*6 +
                    1 1*2 + 2 *1  1*3 + 2*2 + 3*1
             */
            arr = new int[15][15];

            for(int i=1;i<15;i++){
                arr[0][i] = i;
            }

            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int K = Integer.parseInt(br.readLine());  // 아파트 층
                int N = Integer.parseInt(br.readLine()); // 아파트 호

                System.out.println(solution(K, N));
            }
        } catch (IOException e){

        }
    }
    public static int solution(int k, int n){
        if(arr[k][n] != 0){
            return arr[k][n];
        }

        int sum = 0;
        for(int nn = 1; nn <= n; nn++){
            sum += solution(k-1, nn);
        }
        arr[k][n] = sum;
        //System.out.printf("arr[%d][%d]=%d\n", k, n, sum);
        return sum;
    }
}

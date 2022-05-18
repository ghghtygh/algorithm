
import java.util.Scanner;

public class Main {

    public Main(int N, int K, int[] arr){

        int res = 0;

        for(int i = N-1; i >= 0; i--){
            int tmp = arr[i];
            while(K >= tmp){
                K -= tmp;
                res++;
            }
        }

        System.out.println(String.valueOf(res));
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        new Main(N, K, arr);

    }
}

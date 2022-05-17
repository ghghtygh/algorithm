import java.util.*;

public class Main {

    public Main(int N, int[] arr){

        int res = 0;
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            res += (N - i) * arr[i];
        }

        System.out.println(String.valueOf(res));
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        new Main(N, arr);

    }
}

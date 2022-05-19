import java.util.Scanner;

public class Main {

    private static int[] arr;  // 받은 숫자 저장
    private static int[] P;  // 계산값 저장

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N+1];
        P = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }

        /*R
                2    1        -4     1     3
        연속합    0+2  1+2      3-4    -1+1   1+3
        연속아님    2    1       -4     1      3
         P       2    3       -1     1      4
         최대값    2   3         3     3       4
         */

        P[1] = arr[1] < 0 ? 0 : arr[1];

        int res = arr[1];    // 최대값
        int tmp;
        for(int i = 2; i <= N; i++){
            tmp = P[i-1] + arr[i];
            P[i] = arr[i] > tmp ? arr[i] : tmp;

            if(res < P[i]){
                res = P[i];
            }
        }

        System.out.println(res);
    }
}

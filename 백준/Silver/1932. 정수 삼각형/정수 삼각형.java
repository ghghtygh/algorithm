import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static int[][] P;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1][N+1];
        P = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(N));
    }
    public static int solution(int N){

        /*
             1                  1
            1 2              1+1  1+2
           3 2 3            1+1+3 1+2+2 1+2+3
          1 2 3 4
         */
        if(N <= 1){
            return arr[1][1];
        }
        P[1][1] = arr[1][1];
        P[2][1] = P[1][1] + arr[2][1];
        P[2][2] = P[1][1] + arr[2][2];
        for(int i=3;i<=N;i++){
            P[i][1] = P[i-1][1] + arr[i][1];
            P[i][i] = P[i-1][i-1] + arr[i][i];
            for(int j=2;j<=i-1;j++) {
                P[i][j] = Math.max(P[i-1][j-1], P[i-1][j]) + arr[i][j];
            }
        }
        int res = P[N][1];
        for(int i=2;i<=N;i++){
            if(res < P[N][i]){
                res = P[N][i];
            }
        }
        return res;
    }
}

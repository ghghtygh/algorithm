import java.util.Scanner;

public class Main {

    private static int[] arr;   // 계단 점수
    private static int[][] P;   // 점수 최대값
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N+1];
        P = new int[N+1][2];

        for(int i=1; i<= N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(N));
    }

    public static int solution(int N){
        /*
        한번에 한계단 or 두계단
        연속 세개 X
                                  10   20      15        25             10                  20
   P[i][1] 직전연속 1개(전o,전전x)     10   10+20   20+15     10+15+25                                             P[i-1]+arr[i]
   P[i][0] 직전연속 0개(전x,전전o)     10   20      10+15     10+20+25       (10+20)+10          (20+15)+20        max(P[i-2][0], P[i-1][0]) + arr[i]

         */
        if(N==1) {
            return arr[1];
        }
        P[1][1] = arr[1];

        P[2][1] = arr[1] + arr[2];
        P[2][0] = arr[2];
        for(int i = 3; i<=N; i++){
            P[i][1] = P[i-1][0] + arr[i];
            P[i][0] = Math.max(P[i-2][0], P[i-2][1]) + arr[i];
        }
        return Math.max(P[N][0], P[N][1]);
    }
}

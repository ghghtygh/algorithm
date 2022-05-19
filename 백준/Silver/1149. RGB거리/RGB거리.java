import java.util.Scanner;

public class Main {

    public static int[][] costArr;
    public static int[][] P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        costArr = new int[N+1][3];
        P = new int[N+1][3];
        for(int i=1; i<=N; i++){
            for(int j=0;j<3;j++){
                costArr[i][j] = sc.nextInt();
            }
        }
        P[1] = costArr[1];
        /*
        R G B   최                      소                값
    1   1 2 3   1                       2                3
    2   2 4 1   min(2,3)+2 -> 4   min(1,3)+2 -> 3  min(1,2)+3 -> 4
    3   4 3 2   min(3,4)+4 -> 7   min(4,4)+3 -> 7  min(4,3)+2 -> 5
         */
        for(int i=2; i<=N; i++){
            P[i][0] = Math.min(P[i-1][1], P[i-1][2]) + costArr[i][0];
            P[i][1] = Math.min(P[i-1][0], P[i-1][2]) + costArr[i][1];
            P[i][2] = Math.min(P[i-1][1], P[i-1][0]) + costArr[i][2];
        }
        System.out.println(Math.min(Math.min(P[N][0], P[N][1]), P[N][2]));
    }
}

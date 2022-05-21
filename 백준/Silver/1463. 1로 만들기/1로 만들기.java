import java.util.Scanner;

public class Main {

    public static int[] P;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        P = new int[(N<=3?4:N+1)];
        /*
        3으로 떨어지면 3으로 나눔
        2로 나누어 떨어지면 2로 나눔
        1을 뺌
        연산횟수의 최소값
         */

        P[1] = 0;
        P[2] = 1;
        if(N >= 3){
            P[3] = 1;
        }
        int tmp;
        for(int i=4;i <= N;i++){
            tmp = P[i-1];
            if(i % 2 == 0){
                if(tmp > P[i/2]){
                    tmp = P[i/2];
                }
            }
            if(i % 3 == 0){
                if(tmp > P[i/3]){
                    tmp = P[i/3];
                }
            }
            P[i] = tmp + 1;
            //System.out.printf("P[%d] = %d\n",i, tmp+1);
        }
        System.out.println(P[N]);
    }
}

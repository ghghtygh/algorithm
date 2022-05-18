
import java.util.Scanner;

public class Main{

    public Main(int N, long[] roadArr, long[] costArr){

        long res = roadArr[0] * costArr[0];
        long nowCost = costArr[0];
        for(int i = 1; i < N - 1; i++){
            nowCost = nowCost > costArr[i] ? costArr[i] : nowCost;
            res += roadArr[i]  * nowCost;
        }
        System.out.println(String.valueOf(res));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] roadArr = new long[N];
        long[] costArr = new long[N];

        for(int i = 0; i < N - 1; i++){
            roadArr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            costArr[i] = sc.nextInt();
        }

        new Main(N, roadArr, costArr);
    }
}

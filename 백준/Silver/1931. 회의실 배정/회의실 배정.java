

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public Main(int N, int[][] arr){

        // 종료시간, 시작시간 순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0]-o2[0]:o1[1]-o2[1]);

        int res = 0;

        int stt = -1;
        for(int i = 0; i < N; i++){
            if(arr[i][0] >= stt){
                stt = arr[i][1];
                res++;
            }
        }

        System.out.println(String.valueOf(res));
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        new Main(N, arr);
    }
}

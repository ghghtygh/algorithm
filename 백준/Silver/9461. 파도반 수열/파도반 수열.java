import java.util.Scanner;

public class Main {

    public static long arr[] = new long[101];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n;

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for(int i = 0; i < N; i++){
            n = sc.nextInt();
            System.out.println(solution(n));
        }

    }

    public static long solution(int n){
        /*
        1 1 1 2 2 3(1+2) 4(1+3) 5(1+4) 7(5+2) 9 (7+2)

        (8) 5 -> -1 -5
        (9) 7 -> -1 -5
        (10) 9 -> -1 -5
        (11) 12 -> -1 + -5
        n = n-1 + n-5

         */
        if(arr[n] == 0) {
            arr[n] = solution(n-1) + solution(n-5);
        }

        return arr[n];
    }


}

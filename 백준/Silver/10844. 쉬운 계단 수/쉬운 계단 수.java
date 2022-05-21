import java.util.Scanner;

public class Main {

    public static long[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new long[N+1][10]; // arr[i][j] : 자리수가 i이고 앞 숫자가 j로 시작하는 계단수
        /*
        계단 수 : 인접한 모든 자리의 차이가 1인 수
        N = 1 -> 9
        N = 2 -> 17
        10 12  21 23 32 34   43 45 54 56 65  67 76 78     87 89  98

    N   0  1  2  3  4  5  6  7  8  9
    2   1  2  2  2  2  2  2  2  2  1 -> 17
    3   2  3  4  4  4  4  4  4  3  2 -> 3 + 24 + 5 =  32
    4   3  6  7  8  8  8  8  7  6  3 -> 13 + 32 + 16 = 61
    5   4 10 14 15 16 16 15 14 10  6 -> 10+29+32+29+19 = 10+32+58+19 = 90+10+19 = 116
        N = 3 -> 32
        101 121 123
        1010 1012
        */
        for(int i = 0; i <= 9; i++) {
            arr[1][i] = 1;
        }

        int mod = 1000000000;
        for(int i = 2; i <= N; i++) {
            for (int j = 1; j <= 8; j++) {
                arr[i][j] = ((arr[i - 1][j - 1] % mod) + (arr[i - 1][j + 1] % mod)) % mod;
            }
            arr[i][0] = arr[i - 1][1];
            arr[i][9] = arr[i - 1][8];
        }

        long res = 0;
        if(N >= 2) {

            // 0으로 시작하는 수는 계단수가 아님
            for (int j = 1; j <= 8; j++) {
                res += ((arr[N - 1][j - 1] % mod) + (arr[N - 1][j + 1] % mod)) % mod;
            }
            res += (arr[N - 1][8]) % mod;
            res %= mod;
        } else {
            res = 9;
        }
        System.out.println(res);
    }
}

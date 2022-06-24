import java.util.Scanner;

public class Main {

    static int[] arr;

    static long cnt1 = 1;
    static long cnt2 = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        fib(N);

        arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 1;
        fibonacci(N);

        System.out.printf("%d %d\n",cnt1, cnt2);
    }

    public static int fib(int n){

        if(n == 1 || n==2){
            return 1;
        }
        cnt1 += 1;
        return fib(n-1) + fib(n-2);
    }

    public static int fibonacci(int n){


        if(arr[n] > 0){
            return arr[n];
        }

        cnt2 += 1;
        arr[n] = fibonacci(n-1) + fibonacci(n-2);
        return arr[n];
    }
}

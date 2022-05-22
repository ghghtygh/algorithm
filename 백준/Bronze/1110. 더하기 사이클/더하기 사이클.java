import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        /*
        1
        01 -> 11 -> 12 -> 23 -> 35 -> 58 -> 83 ->
         */

        int idx = 0;
        int M = N;
        while(true){
            if(idx > 0 && N == M){
                break;
            }
            int a = M / 10;
            int b = M % 10;

            int c = (a+b) % 10;
            M = (b * 10) + c;
            idx++;
            // System.out.printf("#%d => %d\n", idx, M);
        }
        
        System.out.println(idx);

    }
}

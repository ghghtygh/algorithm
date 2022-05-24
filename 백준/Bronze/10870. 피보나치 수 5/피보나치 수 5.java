import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fb(N));
    }
    public static int fb(int N){
        if(N <= 1){
            return N;
        }
        return fb(N-1) + fb(N-2);
    }
}

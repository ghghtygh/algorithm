import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        arr[0] = sc.nextInt();
        int max = arr[0];
        for(int i = 1; i < N; i++){
            int tmp = sc.nextInt();
            arr[i] = tmp;
            if(tmp > max){
                max = tmp;
            }
        }
        double sum = 0;
        for(int i=0;i<N;i++){
            sum += (((double) arr[i] / max) * 100.0);
        }
        System.out.println(sum / N);
    }
}

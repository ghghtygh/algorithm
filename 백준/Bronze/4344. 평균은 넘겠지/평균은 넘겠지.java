import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            int M = sc.nextInt();
            int[] arr = new int[M];
            for(int j=0;j<M;j++){
                arr[j] = sc.nextInt();
            }
            // 소수점 3자리까지 출력
            System.out.printf("%.3f%%\n",solution(arr));
        }
    }

    public static double solution(int[] arr){
        // 평균
        double avg = Arrays.stream(arr).average().orElse(0);

        // 평균 넘는 학생 수
        int count = (int) Arrays.stream(arr).filter(i -> i > avg).count();

        // 평균 넘는 학생 수 비율
        return (count / (arr.length * 1.0)) * 100.0;
    }
}

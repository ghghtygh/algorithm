import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr1;
    //static int[] arr2;
    static Integer[] arr2;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int N = Integer.parseInt(br.readLine());
            arr1 = new int[N+1];
//            arr2 = new int[N+1];
            arr2 = new Integer[N+1];
            for (int i = 1; i <= N; i++) {
                arr1[i] = Integer.parseInt(br.readLine());
            }

            /*
            arr2[N] = N까지의 최대값
             */
            arr2[0] = 0;
            arr2[1] = arr1[1];
            if (N >= 2) {
                arr2[2] = arr1[1] + arr1[2];
            }

            System.out.println(recur(N));

        } catch (IOException e) {
        }
    }

    static int recur(int idx) {

        //if(arr2[idx] == 0 && idx > 2) {
        if(arr2[idx] == null) {
            arr2[idx] = Math.max(Math.max(recur(idx - 3) + arr1[idx - 1] , recur(idx - 2))+ arr1[idx], recur(idx - 1));
        }
        return arr2[idx];
    }

}

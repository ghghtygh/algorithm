import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int N = Integer.parseInt(br.readLine());
            long sum = 0;
            int[] arr = new int[N];
            int[] arr2 = new int[8001];
            for(int i = 0; i < N; i++){
               arr[i] = Integer.parseInt(br.readLine());
               sum += arr[i];
               arr2[arr[i]+4000] += 1;
            }

            int maxIdx = -1; // 최빈값
            int max = -1; // 최대 개수
            for(int i = 0; i <= 8000; i++){
                if(arr2[i] > max){
                    max = arr2[i];
                }
            }
            for(int i = 0; i <= 8000; i++) {
                if (arr2[i] == max) {
                    // 여러개일 경우 두번째로 큰 수
                    if (maxIdx > -1) {
                        maxIdx = i;
                        break;
                    }

                    maxIdx = i;
                }
            }

            Arrays.sort(arr);

            System.out.println(Math.round(sum / (float) N ));
            System.out.println(arr[(N-1)/2]);
            System.out.println(maxIdx - 4000);
            System.out.println(arr[N-1] - arr[0]);
        } catch(IOException e ){

        }
    }
}

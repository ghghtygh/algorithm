import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            int[] arr1 = new int[N+1];

            // arr2[idx][0] : 왼쪽 -> 오른쪽 순으로 증가하는 수열 개수
            // arr2[idx][1] : 오른쪽 -> 왼쪽 순으로 증가하는 수열 개수
            int[][] arr2 = new int[N+1][2];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 1; i <= N; i++){
                arr1[i] = Integer.parseInt(st.nextToken());

                // 왼쪽 -> 오른쪽 순으로 증가하는 수열 개수 구하기
                arr2[i][0] = 1;
                for(int j = 1; j < i; j++){

                    int tmp = arr2[j][0] + 1;
                    // 이미 더 큰 수열일 경우
                    if(arr2[i][0] >= tmp){
                        continue;
                    }

                    // 증가하면
                    if(arr1[i] > arr1[j]){
                        arr2[i][0] = tmp;
                    }
                }
            }
            // 오른쪽 -> 왼쪽으로 증가하는 수열 구하기
            arr2[N][1] = 1;
            for(int i = N-1; i >= 1; i--){
                arr2[i][1] = 1;
                for(int j = i+1; j <= N; j++) {
                    int tmp = arr2[j][1] + 1;
                    if(arr2[i][1] >= tmp){
                        continue;
                    }
                    if(arr1[i] > arr1[j]){
                        arr2[i][1] = tmp;
                    }
                }
            }

            // 바이토닉 수열 최대값 구하기
            int res = 0;
            for(int i = 1; i <= N; i++){
                // System.out.printf("%d %d %d\n", arr1[i], arr2[i][0], arr2[i][1]);
                
                int tmp = arr2[i][0] + arr2[i][1] - 1;
                if(tmp > res){
                    res = tmp;
                }
            }
            System.out.println(res);

        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}

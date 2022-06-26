import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            arr1 = new int[N+1];
            arr2 = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 1; i <= N; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            arr2[1] = 1;

            int res = -1;
            for(int i = 1; i <= N; i++){
                int tmp = recur(i);
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
    static int recur(int idx){

        if(arr2[idx] == 0){

            arr2[idx] = 1;

            for(int i = 1; i < idx; i++){
                if(arr1[idx] > arr1[i]){

                    int tmp = recur(i) + 1;

                    if(tmp > arr2[idx]){
                        arr2[idx] = recur(i) + 1;
                    }

                }
            }
        }

        return arr2[idx];
    }
}

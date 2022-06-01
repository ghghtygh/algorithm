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
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            for(int a : arr){
                System.out.println(a);
            }


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

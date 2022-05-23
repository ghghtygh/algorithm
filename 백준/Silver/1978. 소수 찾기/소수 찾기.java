import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = N;

            for(int k=0;k<N;k++){
                if(arr[k] == 1){
                    count--;
                }
            }

            loop1:for(int i=2;i<=1000;i++){
                if(count <= 0){
                    break loop1;
                }
                loop2:for(int j = 2; j < i; j++){
                    if(i % j == 0){
                        // 소수가 아님
                        for(int k=0;k<N;k++){
                            if(arr[k] == i){
                                count--;
                                break loop2;
                            }
                        }
                        break loop2;
                    }
                }
            }
            System.out.println(count);
        } catch (IOException e){

        }
    }
}

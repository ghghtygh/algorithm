import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            for(int i = N; i >= 1; i--){

                int tmp = i;
                while(tmp%5==0){
                    tmp /= 5;
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        } catch(IOException e){

        }
    }
}

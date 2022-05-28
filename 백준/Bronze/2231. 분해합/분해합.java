import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ) {
            int N = Integer.parseInt(br.readLine());
            int min = N;

            for(int i = N - 1; i >= 1; i--) {
                int t = i;
                int tmp = i;
                while(t / 10 != 0){
                    tmp += t % 10;
                    t = t / 10;
                }
                tmp += t % 10;
                if(tmp == N && i < min){
                   min = i;
                }
            }
            System.out.println(min==N?0:min);
        } catch (IOException e){

        }
    }
}

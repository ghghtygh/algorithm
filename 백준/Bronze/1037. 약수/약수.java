import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int max = Integer.parseInt(st.nextToken());
            int min = max;

            for(int i = 1; i < N; i++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp > max) {
                    max = tmp;
                }
                if(tmp < min) {
                    min = tmp;
                }
            }
            System.out.println(max * min);

        }catch(IOException e){

        }
    }
}

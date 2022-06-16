import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            StringBuffer sb = new StringBuffer();
            for(int i = 1; i < N; i++){

                int tmp = Integer.parseInt(st.nextToken());
                int g = gcd(n, tmp);

                sb.append(n/g).append("/").append(tmp/g).append("\n");
            }
            System.out.print(sb);
        } catch(IOException e){

        }
    }

    public static int gcd(int A, int B){
        if(B == 0){
            return A;
        }
        return gcd(B, A % B);
    }
}

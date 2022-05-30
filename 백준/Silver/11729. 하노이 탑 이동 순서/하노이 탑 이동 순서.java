import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb;
    public static void main(String[] args){

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ) {
            int N = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            sb.append(((int) Math.pow(2, N) - 1)+"\n");
            solution(N, 1, 3, 2);

            System.out.println(sb);
        } catch (IOException e){

        }

    }

    public static void solution(int N, int from, int to, int now){
        if(N == 1){
            sb.append(from + " " + to + "\n");
            return;
        }

        solution(N-1, from, now, to);

        sb.append(from + " " + to + "\n");

        solution(N-1, now, to, from);
    }
}

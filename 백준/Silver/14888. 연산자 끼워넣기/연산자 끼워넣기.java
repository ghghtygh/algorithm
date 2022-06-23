import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] numbers;
    int[] operators;
    int N;
    long max = -1000000000;
    long min = 1000000000;
    public Main(int N){
        numbers = new int[N];
        operators = new int[4];
        this.N = N;
    }

    public void recur(int depth, long now, int[] oprs){

        if(depth == N) {
            if(now > max){
                max = now;
            }

            if(now < min){
                min = now;
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            if(oprs[i] > 0){
                oprs[i] -= 1;

                long next = numbers[depth];
                if(i==0) {
                    next = now + next;
                }
                else if(i==1) {
                    next = now - next;
                }
                else if(i==2) {
                    next = now * next;
                }
                else if(i==3) {
                    next = now / next;
                }
                recur(depth + 1, next, oprs);
                oprs[i] += 1;
            }
        }
    }

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            Main main = new Main(N);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < N; i++){
                main.numbers[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < 4; i++){
                main.operators[i] = Integer.parseInt(st.nextToken());
            }

            main.recur(1, main.numbers[0], main.operators);

            System.out.printf("%d\n%d\n", main.max, main.min);

        } catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}

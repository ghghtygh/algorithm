import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static char[][] arr;
    public static void main(String[] args){

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ) {
            int N = Integer.parseInt(br.readLine());

            arr = new char[N + 1][N + 1];

            for(char[] ar : arr){
                Arrays.fill(ar, ' ');
            }
            recur(N, 3, 3);

            printStar(N);
        } catch(IOException e){

        }
    }

    public static void recur(int N, int I, int J){

        for(int i = 1; i <= 3; i++){

            for(int j = 1; j<= 3; j++){
                if(i!=2 || j!=2){
                    if(N==3){
                        //System.out.printf("%d,%d>> (%d,%d)\n",I,J,i,j);
                        arr[I-i+1][J-j+1] = '*';
                    } else {
                        recur(N/3, I+(N/3*(i-1)), J+(N/3*(j-1)));
                    }
                }
            }
        }
    }

    public static void printStar(int N){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= N; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.printf(sb.toString());
    }
}

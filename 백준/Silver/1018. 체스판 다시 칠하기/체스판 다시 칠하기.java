import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static char[][] arr;
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];

            for(int i = 0; i < N; i ++){
                arr[i] = br.readLine().toCharArray();
            }

            int x1 = 0;

            int min = N*M;
            for(int i = 8; i <= N; i++){
                int y1 = 0;
                for(int j = 8; j <= M; j++){

                    int tmp = solution(x1, i, y1, j);
                    if(tmp < min){
                        min = tmp;
                    }

                    y1++;
                }
                x1++;
            }
            System.out.println(min);
        } catch(IOException e){

        }
    }
    public static int solution(int x1, int x2, int y1, int y2){

        int bc1 = 0;
        int wc1 = 0;
        int bc2 = 0;
        int wc2 = 0;
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                if((i + j) % 2 == 0){
                    if(arr[i][j] == 'B'){
                        bc1 += 1;
                    } else{
                        wc1 += 1;
                    }
                }else{
                    if(arr[i][j] == 'B'){
                        bc2 += 1;
                    } else{
                        wc2 += 1;
                    }
                }
            }
        }
        int c1 = 64 - (bc1 + wc2);
        int c2 = 64 - (wc1 + bc2);

        return Math.min(c1,c2);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    int N;
    int cnt;
//    int[] arr;
    public Main(int N){
        cnt = 0;
        this.N = N;
//        this.arr = new int[N];
    }

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());

            Main main = new Main(N);
            main.recur(0, new int[N]);
            System.out.println(main.cnt);

        } catch(IOException e) {    }
    }
    /*
    행 별로 퀸이 들어갈 수 있는 자리 수 세기
     */
    public void recur(int row, int[] arr){

        if(row == N){
            cnt += 1;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[row] = i;
            if(isVisit(row, arr)){
                recur(row + 1, arr);
            }
        }
    }

    public Boolean isVisit(int col, int[] arr){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]){
                return false;
            }
            if( Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}

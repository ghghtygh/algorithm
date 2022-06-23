import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[][] arr = new int[9][9];

    Boolean isFinished = false;
    public Main(){

    }
    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            Main main = new Main();
            StringTokenizer st;
            for(int i = 0; i < 9 ; i++){
                 st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 9; j++){
                    main.arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            main.recur(0,0, main.copyArr(main.arr));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void recur(int row, int col, int[][] res){

        if(isFinished){
            return;
        }

        if(col > 8){
            recur(row + 1, 0, res);
            return;
        }

        if(row > 8) {
            if(!isFinished){
                printArr(res);
                isFinished = true;
            }
            return;
        }
        if(res[row][col] == 0){
            for(int n = 1; n <= 9; n++){

                res[row][col] = n;
                if(isValid(row, col, res)){
                    int[][] tmp = copyArr(res);
                    res[row][col] = 0;
                    recur(row, col + 1, tmp);
                }

            }
            return;
        } else {
            recur(row, col + 1, res);
        }

    }
    public Boolean isValid(int row, int col, int[][] res){

        if(res[row][col]==0){
            return false;
        }

        for(int i = 0; i < 9; i++){
            if(res[i][col] == res[row][col] && i != row){
                return false;
            }
            if(res[row][i] == res[row][col] && i != col){
                return false;
            }
        }

        int tmp1 = (row / 3) * 3;
        int tmp2 = (col / 3) * 3;

        for(int i = tmp1; i < tmp1 + 3; i++){
            for(int j = tmp2; j < tmp2 + 3; j++){
                if(res[i][j] == res[row][col] && !(i == row && j == col)){
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] copyArr(int[][] res) {
        int[][] tmp = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                tmp[i][j] = res[i][j];
            }
        }
        return tmp;
    }
    public void printArr(int[][] res){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

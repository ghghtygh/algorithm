
import java.util.Scanner;

public class Main {

    private int[][][] arr;
    public int w(int a, int b, int c){

        if(a<=0||b<=0||c<=0){
            return 1;
        }else if(a>20||b>20||c>20){
            a = 20;
            b = 20;
            c = 20;
        }

        if(arr[a][b][c] != 0){
            return arr[a][b][c];
        }

        int res;

        if(a<b && b<c){
            res = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            res = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        arr[a][b][c] = res;
        return res;
    }
    public void solution(int a, int b, int c){
        int res = w(a, b, c);
        System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, res);
    }
    public Main(){
        arr = new int[21][21][21];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        Main main = new Main();
        while(true){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            main.solution(a, b, c);
        }

    }
}


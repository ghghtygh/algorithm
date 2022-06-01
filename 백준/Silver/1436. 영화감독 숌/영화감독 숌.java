import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int n = 0;
        int idx = 666;
        while(true){

            String tmp = String.valueOf(idx);

            if(tmp.indexOf("666") > -1){
                n++;
            }

            if(n == N){
                break;
            }

            idx += 1;
        }

        System.out.println(idx);

    }
}

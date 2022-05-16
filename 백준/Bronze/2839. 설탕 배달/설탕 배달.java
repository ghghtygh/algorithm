import java.util.*;
public class Main {

    public Main(int N) {

        int maxX = 1;
        int res = -1;
        if(N == 3 || N == 5) {
            res = 1;
        } else if (N < 5) {
            res = -1;
        } else if(N % 5 == 0) {
            res = N / 5;
        } else{
            
            while(N > maxX * 3) {
                maxX++;
            }

            for(int i = 1; i < maxX; i++){
                if((N - (3 * i)) % 5 == 0){
                    res = ((N - (3 * i)) / 5) + i;
                    break;
                }
            }

            if(res == -1 && N % 3 == 0){
                res = maxX;
            }
        }

        System.out.println(res);

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        new Main(N);

    }

}

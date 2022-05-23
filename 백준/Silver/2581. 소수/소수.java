import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int min = N;
        int sum = 0;
        for(int i = M;i<=N;i++){
            if(isPrimeNo(i)){
                sum += i;
                min = min > i ? i : min;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static Boolean isPrimeNo(int num){

        if(num == 1){
            return false;
        }

        int rep = num / 2;

        for(int i=2;i<=rep;i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}

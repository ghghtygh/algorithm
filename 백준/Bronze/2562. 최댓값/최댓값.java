import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int max = sc.nextInt();
        int maxIdx = 1;
        for(int i=2; i<=9;i++){
            int tmp = sc.nextInt();
            if(tmp > max){
                max = tmp;
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx);
    }
}

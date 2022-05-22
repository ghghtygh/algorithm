import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        for(int i = 1; i <= N; i++){
            cnt += solution(i);
        }
        System.out.println(cnt);
    }
    public static int solution(int idx){
        if(idx < 10) {
            return 1;
        }
        char[] chArr = Integer.toString(idx).toCharArray();
        int dt = chArr[1] - chArr[0];
        for(int i = 2; i < chArr.length; i++){
            if(chArr[i] - chArr[i-1] != dt){
                return 0;
            }
        }

        return 1;
    }
}

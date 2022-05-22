import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            System.out.println(solution(str));
        }
    }
    public static int solution(String str){
        int score = 0;

        int n = 0;
        for(char ch : str.toCharArray()){
            if(ch == 'O'){
                score += ++n;
            }else{
                n = 0;
            }
        }

        return score;
    }
}

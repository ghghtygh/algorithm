import java.util.Scanner;

public class Main {

    public final static String STR0 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";

    public final static String Q1 = "\"재귀함수가 뭔가요?\"";

    public final static String A1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    public final static String A2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    public final static String A3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    public final static String A4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";

    public final static String A5 = "라고 답변하였지.";

    public final static String LINE = "____";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(STR0);
        solution(N, 0);

    }

    public static void solution(int N, int i){
        if(N<0){
            return;
        }
        String line = "";
        for (int ii = 0; ii < i; ii++) {
            line += LINE;
        }
        System.out.println(line + Q1);
        if(N > 0) {
            System.out.println(line + A1);
            System.out.println(line + A2);
            System.out.println(line + A3);
            solution(N-1, i+1);
        } else {
            System.out.println(line + A4);
        }
        System.out.println(line + A5);
    }
}

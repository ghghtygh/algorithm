import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(sc.nextLine());

        for(int i=0;i<N;i++){
            String str = sc.nextLine();
            st = new StringTokenizer(str," ");
            sb = new StringBuilder();
            int M = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();
            for(char ch : arr){
                for(int j = 0; j < M; j++){
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }

    }
}

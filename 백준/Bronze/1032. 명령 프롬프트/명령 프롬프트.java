import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] files = new String[N];

        if(N == 1){
            System.out.println(sc.next());
        } else {
            StringBuffer sb = new StringBuffer();

            for(int i=0; i<N; i++){
                files[i] = sc.next();
            }

            int M = files[0].length();

            for(int j=0;j<M;j++) {
                char c = files[0].charAt(j);
                Boolean isDiff = false;
                for (int i = 1; i < N; i++) {
                    if(c != files[i].charAt(j)){
                        isDiff = true;
                    }
                }
                sb.append(isDiff ? "?":c);
            }
            System.out.println(sb.toString());
        }

    }
}

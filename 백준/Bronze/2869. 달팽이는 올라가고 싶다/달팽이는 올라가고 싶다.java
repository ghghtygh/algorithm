import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){

        /*
        시간초과로 인해 수정
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();   // 낮에 올라가는 거리
        int B = sc.nextInt();   // 밤에 떨어지는 거리
        int V = sc.nextInt();   // 나무막대의 높이
        */
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                ){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int u = A-B; // 하루에 올라갈 수 있는 거리

            // 시간초과로 인해 수정
            // System.out.println((int)Math.ceil((V-A)*1.0 / u) + 1);

            int days = ((V - A) / u) + 1; // 소요 기간
            if( (V - A) % u != 0){
                // 올림 함수 대신 사용
                days += 1;
            }

            System.out.println(days);
        }catch(IOException e1){}


    }
}

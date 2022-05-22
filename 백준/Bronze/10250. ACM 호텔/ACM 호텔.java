import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++){

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int H = Integer.parseInt(st.nextToken()); // 호텔 층 수
                int W = Integer.parseInt(st.nextToken()); // 층별 방 수
                int N = Integer.parseInt(st.nextToken()); // 손님 순번


                //
                int floor = ((N-1) % H )+ 1;

                //
                int roomNo = ((N-1)/H)+1;

                System.out.println(floor * 100 + roomNo);
            }

        } catch(IOException e){

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int solution(String str){

        StringTokenizer st = new StringTokenizer(str, " ");
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        if(x1 == x2 && y1 == y2){
            if(r1 == r2){
                return -1;
            }else{
                return 0;
            }
        }

        double dt = Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2);
        double rt = Math.pow((r1 + r2), 2);
        double rm = Math.pow((r1 - r2), 2);

        if(dt == rt){  // 외접
            return 1;
        } else if(dt > rt) { // 거리가 먼 경우
            return 0;
        } else if(dt == rm){ // 내접
            return 1;
        } else if(dt < rm){ // 접점이 없는 경우
            return 0;
        } else {
            return 2;
        }

    }
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < N; i++){
                sb.append(solution(br.readLine())).append("\n");
            }
            System.out.print(sb);
        } catch(IOException e){

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int R = H / 2;

            int res = 0;
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(isCorpInBox(x, y, X, Y, W, H) || isCorpInCircle(x, y, X, Y+R, R) || isCorpInCircle(x, y, X+W, Y+R, R)) {
                    res += 1;
                }
            }
            System.out.println(res);

        } catch (IOException e) {

        }
    }

    public static Boolean isCorpInCircle(int x, int y, int X, int Y, int R){

        int dt = (int) (Math.pow(x-X, 2) + Math.pow(y-Y, 2));

        if( dt <= (int) Math.pow(R, 2)){
            return true;
        }

        return false;
    }
    public static Boolean isCorpInBox(int x, int y, int X, int Y, int W, int H){

        if(x >= X && x <= X+W && y >= Y && y <= Y+H){
            return true;
        }

        return false;
    }
}

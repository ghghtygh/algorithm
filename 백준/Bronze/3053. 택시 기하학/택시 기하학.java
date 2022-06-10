import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int r = Integer.parseInt(br.readLine());
            long r2 = r*r;
            double res1 = Math.round(r2 * Math.PI * 1000000)/1000000.0;
            double res2 = r2 * 2.0;
            System.out.printf("%.6f\n%.6f\n",res1,res2);
        } catch(IOException e){

        }
    }
}

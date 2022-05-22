import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            int N = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();

            int sum = 0;
            for(char ch : arr){
                sum += (int) ch - '0';
            }

            System.out.println(sum);
        } catch(IOException e1){

        }


    }
}

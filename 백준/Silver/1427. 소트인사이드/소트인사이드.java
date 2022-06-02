import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            String N = br.readLine();
            char[] arr = N.toCharArray();
            Arrays.sort(arr);
            StringBuffer sb = new StringBuffer(new String(arr));
            System.out.println(sb.reverse().toString());
        } catch (IOException e){

        }
    }
}

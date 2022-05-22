import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String A = new StringBuilder(st.nextToken()).reverse().toString();
            String B = new StringBuilder(st.nextToken()).reverse().toString();

            if(A.length() > B.length()){
                System.out.println(A);
            }else if(A.length() < B.length()){
                System.out.println(B);
            }else{
                for(int i = 0; i < A.length(); i++){
                    if(A.charAt(i) > B.charAt(i)) {
                        System.out.println(A);
                        break;
                    } else if(A.charAt(i) < B.charAt(i)){
                        System.out.println(B);
                        break;
                    }else{
                        continue;
                    }
                }
            }
        } catch(IOException e){

        }
    }
}

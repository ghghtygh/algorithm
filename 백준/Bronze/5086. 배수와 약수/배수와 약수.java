
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            String str = "";
            StringBuffer sb = new StringBuffer();
            StringTokenizer st;
            while((str = br.readLine()) != null){

                if("0 0".equals(str)){
                    break;
                }
                st = new StringTokenizer(str, " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if(A < B && B % A == 0) {
                    sb.append("factor").append("\n");
                } else if(A > B &&  A % B == 0) {
                    sb.append("multiple").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            }

            System.out.print(sb);
        } catch(IOException e){

        }
    }
}

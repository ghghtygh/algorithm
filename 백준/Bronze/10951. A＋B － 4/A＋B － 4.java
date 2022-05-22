import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {

            StringBuilder sb = new StringBuilder();
            String readStr;
            StringTokenizer st;
            while((readStr = br.readLine()) != null){

                // 문자열 분리를 위한 StringTokenizer 클래스 이용
                st = new StringTokenizer(readStr, " ");

                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                sb.append(num1+num2);
                sb.append("\n");
            }
            System.out.print(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

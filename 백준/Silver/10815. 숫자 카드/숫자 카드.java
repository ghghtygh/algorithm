import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int tmp = Integer.parseInt(st.nextToken());
                set.add(tmp);
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < M; i++){
                int tmp = Integer.parseInt(st.nextToken());
                sb.append((set.contains(tmp))?"1":"0").append(" ");
            }
            System.out.println(sb.toString().trim());

        } catch (IOException e){}
    }
}

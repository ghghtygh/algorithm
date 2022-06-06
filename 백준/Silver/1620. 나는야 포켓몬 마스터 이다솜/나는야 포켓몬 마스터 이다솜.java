import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Map<String, String> map = new HashMap<>();
            for(int i = 1; i <= N; i++){
                String num = String.valueOf(i);
                String name = br.readLine();
                map.put(num, name);
                map.put(name, num);
            }

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < M; i++){
                String k = br.readLine();
                sb.append(map.get(k)).append("\n");
            }
            System.out.print(sb);
        } catch(IOException e){}
    }
}

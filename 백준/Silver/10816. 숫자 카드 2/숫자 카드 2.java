import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                String k = st.nextToken();
                int v = 0;
                if(map.containsKey(k)){
                    v = map.get(k);
                }
                map.put(k, ++v);
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < M; i++){
                String k = st.nextToken();
                if(map.containsKey(k)){
                    sb.append(map.get(k)).append(" ");
                }else{
                    sb.append("0 ");
                }
            }
            System.out.println(sb.toString().trim());
        } catch(IOException e){

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            /*
               head     2
               eye      1
               -> 3 2
               ( 3 * 2 ) - 1
             */
            int N = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(br.readLine());
                Map<String, Object> map = new HashMap<>();
                for(int i=0; i<n; i++){
                    StringTokenizer st = new StringTokenizer(br.readLine()," ");
                    String name = st.nextToken();
                    String key = st.nextToken();
                    if(map.containsKey(key)){
                        int cnt = (int) map.get(key) + 1;
                        map.put(key, cnt);
                    }else{
                        map.put(key, 2);
                    }
                }

                int res = 1;
                for(String key : map.keySet()){
                    int c = (int) map.get(key);
                    res *= c;
                }
                res -= 1;

                sb.append(res).append("\n");
            }

            System.out.print(sb);
        } catch(IOException e){ }
    }
}

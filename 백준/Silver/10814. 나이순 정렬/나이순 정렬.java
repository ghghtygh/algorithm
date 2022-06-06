import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());
            List<Map<String, Object>> list = new ArrayList<>();

            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");

                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                Map<String, Object> map = new HashMap<>();
                map.put("index", i);
                map.put("age", age);
                map.put("name", name);

                list.add(map);
            }

            Collections.sort(list, (o1, o2) -> {
                if (o1.get("age") == o2.get("age")) {
                    return (int) o1.get("index") - (int) o2.get("index");
                } else {
                    return (int) o1.get("age") - (int) o2.get("age");
                }
            });

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < N; i++){
                Map<String, Object> map = list.get(i);
                sb.append(map.get("age"));
                sb.append(" ");
                sb.append(map.get("name"));
                sb.append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {}
    }
}

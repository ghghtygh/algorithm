import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Map<Object, Object> map = new HashMap<>();
            SortedSet<Integer> set = new TreeSet<>(Arrays.asList(arr));
            int v = 0;
            for(Integer k : set){
                map.put(k, v++);
            }

            StringBuffer sb = new StringBuffer();
            for(Integer k : arr){
                sb.append(map.get(k));
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        } catch (IOException e){}
    }
}

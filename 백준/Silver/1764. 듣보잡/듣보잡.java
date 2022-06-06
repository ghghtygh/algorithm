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
            Set<String> set = new HashSet<>();
            for(int i = 0; i < N; i++){
                set.add(br.readLine());
            }
            SortedSet<String> sortedSet = new TreeSet<>();
            for(int i = 0; i < M; i++){
                String tmp = br.readLine();
                if(set.contains(tmp)){
                    sortedSet.add(tmp);
                }
            }

            StringBuffer sb = new StringBuffer();
            sb.append(sortedSet.size()).append("\n");
            for(String str : sortedSet){
                sb.append(str).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e){

        }
    }
}

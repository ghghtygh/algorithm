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

            String[] arr = new String[N];
            for(int i = 0; i < N; i++){
                arr[i] = br.readLine();
            }
            int res = 0;

            List<String> list = Arrays.asList(arr);
            for(int i = 0; i < M; i++){
                String tmp = br.readLine();
                /*loop2:for (String s : arr) {
                    if(tmp.equals(s)){
                        res ++;
                        break loop2;
                    }
                }*/
                if(list.contains(tmp)){
                    res += 1;
                }
            }
            System.out.println(res);

        } catch (IOException e) {}
    }
}

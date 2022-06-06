import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            String str = br.readLine();
            Set<String> set = new HashSet<>();
            int len = str.length();
            for(int i = 0; i < len; i++) {
                for(int j = i+1; j <= len; j++){
                    set.add(str.substring(i, j));
                }
            }
            System.out.println(set.size());
        }catch(IOException e){

        }
    }
}

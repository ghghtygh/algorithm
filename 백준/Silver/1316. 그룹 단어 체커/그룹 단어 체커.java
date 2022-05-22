import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(isGroupWord(br.readLine())){
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        } catch (IOException e){

        }
    }

    public static boolean isGroupWord(String str){
        int[] arr = new int['z'-'a'+1];
        Arrays.fill(arr, -1);
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int idx = chars[i] - 'a';
            if(arr[idx] < 0 || arr[idx] == i-1){
                arr[idx] = i;
            } else {
                return false;
            }
        }
        return true;
    }
}

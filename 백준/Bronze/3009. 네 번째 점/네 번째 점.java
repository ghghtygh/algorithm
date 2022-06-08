import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st;
            int[][] arr = new int[3][2];
            for(int i = 0 ; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int x;
            int y;
            if(arr[0][0] == arr[1][0]){
                x = arr[2][0];
            } else if(arr[1][0] == arr[2][0]){
                x = arr[0][0];
            }else{
                x = arr[1][0];
            }

            if(arr[0][1] == arr[1][1]){
                y = arr[2][1];
            } else if(arr[1][1] == arr[2][1]){
                y = arr[0][1];
            }else{
                y = arr[1][1];
            }
            System.out.printf("%d %d\n",x,y);
        } catch(IOException e){ }
    }
}

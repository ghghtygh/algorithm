import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            String str;
            StringTokenizer st;
            int[] arr;
            StringBuffer sb = new StringBuffer();
            while(true) {
                str = br.readLine();

                if("0 0 0".equals(str)){
                    break;
                }

                st = new StringTokenizer(str, " ");
                arr = new int[3];
                for(int i = 0; i < 3; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                Arrays.sort(arr);

                if(Math.pow(arr[2], 2) == (Math.pow(arr[1], 2)+Math.pow(arr[0], 2))){
                    sb.append("right\n");
                }else{
                    sb.append("wrong\n");
                }
            }

            System.out.print(sb);
        }catch(IOException e){

        }
    }
}

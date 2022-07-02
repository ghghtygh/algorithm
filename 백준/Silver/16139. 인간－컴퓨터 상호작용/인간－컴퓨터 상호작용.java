import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();

        int[][] arr = new int['z' - 'a' + 1][len];

        for(int i = 0; i < len; i++) {

            int idx = str.charAt(i) - 'a';

            for(int j = 0; j < arr.length; j++){
                if(i > 0) {
                    arr[j][i] = arr[j][i - 1];
                }
                if(idx == j){
                    arr[j][i] += 1;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine(), " ");

            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] tmp = arr[ch - 'a'];

            if(l == 0) {
                sb.append(tmp[r]).append("\n");
            } else {
                sb.append(tmp[r] - tmp[l - 1]).append("\n");
            }

        }
        System.out.print(sb);
    }
}

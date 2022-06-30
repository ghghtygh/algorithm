import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static Integer[][] dp;
    static char[] chars1;
    static char[] chars2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int l1 = str1.length();
        int l2 = str2.length();

        chars1 = str1.toCharArray();
        chars2 = str2.toCharArray();

        dp = new Integer[l1][l2];

        int res = recur(l1-1, l2-1);
        System.out.println(res);
    }

    static int recur(int i, int j) {

        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] == null){

            if(chars1[i] == chars2[j]){
                dp[i][j] = recur(i-1, j-1) + 1;
            } else {
                dp[i][j] = Math.max(recur(i-1,j), recur(i, j-1));
            }
        }
        return dp[i][j];
    }
}

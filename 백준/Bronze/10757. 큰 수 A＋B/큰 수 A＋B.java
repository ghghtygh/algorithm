import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int length = 0;
            char[] arr1, arr2;
            if(str1.length() > str2.length()){
                arr1 = new StringBuilder(str1).reverse().toString().toCharArray();
                int tmp = str1.length() - str2.length();
                char[] tmpArr = new char[tmp];
                Arrays.fill(tmpArr,'0');
                arr2 = new StringBuilder(new String(tmpArr)).append(str2).reverse().toString().toCharArray();
                length = str1.length();

            }else{
                arr2 = new StringBuilder(str2).reverse().toString().toCharArray();
                int tmp = str2.length() - str1.length();
                char[] tmpArr = new char[tmp];
                Arrays.fill(tmpArr,'0');
                arr1 = new StringBuilder(new String(tmpArr)).append(str1).reverse().toString().toCharArray();
                length = str2.length();
            }

            int n = 0;

            StringBuilder sb = new StringBuilder();
            for(int i=0; i < length; i++){
                int a = arr1[i]-'0'+arr2[i]-'0'+n;
                int b = a%10;
                n = a/10;
                sb.append((char)(b+'0'));
            }
            if(n != 0){
                sb.append((char)(n+'0'));
            }
            System.out.println(sb.reverse().toString());
        } catch(IOException e){

        }
    }
}

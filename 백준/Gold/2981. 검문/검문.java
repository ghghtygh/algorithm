import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            int gc = gcdInArr(arr);
            StringBuffer sb = new StringBuffer();
            for(int i = 2; i <= gc; i++){
                if (gc % i == 0){
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb.toString().trim());

        }catch(IOException e){

        }
    }
    public static int gcdInArr(int[] arr){
        int l = arr.length - 1;
        int gc = arr[1] - arr[0];
        for(int i = l; i >= 1; i--){
            gc = gcd(gc, arr[i] - arr[i-1]);
        }

        return gc;
    }

    public static int gcd(int A, int B){
        if(B == 0){
            return A;
        }
        return gcd(B, A % B);
    }
}

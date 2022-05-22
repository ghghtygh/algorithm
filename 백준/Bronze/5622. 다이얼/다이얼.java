import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                ){
            char[] arr = br.readLine().toCharArray();
            int sum = 0;
            for(char ch : arr){

                /*
                A,B,C = 3초
                D,E,F = 4초
                */
                int dNum;
                if(ch <= 'R'){
                    dNum = (ch - 'A') / 3 + 3;
                }else if(ch == 'S') {
                    dNum = 8;
                } else if(ch <= 'V'){
                    dNum = 9;
                } else {
                    dNum = 10;
                }

                sum += dNum;
            }

            System.out.println(sum);

        }catch(IOException e){

        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        char[] chArr = sc.nextLine().toCharArray();

        int[] intArr = new int['z'-'a'+1];
        Arrays.fill(intArr, -1);

        for(int i = 0; i < chArr.length; i++){
            int tmp = chArr[i] - 'a';
            if(intArr[tmp] < 0){
                intArr[tmp] = i;
            }
        }

        for(int i : intArr){
            System.out.printf("%d ",i);
        }
    }
}

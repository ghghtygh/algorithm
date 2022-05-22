import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[10];

        for(char ch : String.valueOf(a*b*c).toCharArray()){
            arr[ch - 48] += 1;
        }
        for (int i=0; i<=9; i++){
            System.out.println(arr[i]);
        }

    }
}

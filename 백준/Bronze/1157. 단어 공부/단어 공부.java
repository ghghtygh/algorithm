import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 알파벳 개수만큼의 배열
        int[] arr = new int['Z'-'A'+1];

        // 입력 받은 단어 -> 대문자 문자 배열 변환
        char[] chArr = sc.nextLine().toUpperCase().toCharArray();

        for(char ch : chArr){
            arr[ch-'A'] += 1;
        }
        int max = Arrays.stream(arr).max().orElse(0);
        int maxIdx = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= max){
                if(maxIdx > -1){
                    // 최대 개수가 두개 이상 일 경우
                    maxIdx = -1;
                    break;
                } else {
                    maxIdx = i;
                }
            }
        }
        if(maxIdx < 0){
            System.out.println("?");
        }else{
            System.out.printf("%c\n",(maxIdx + 'A'));
        }
    }
}

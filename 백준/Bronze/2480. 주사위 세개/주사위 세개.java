import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int res = 0;    // 상금
        int[] arr = new int[3]; // 주사위 숫자
        for(int i = 0; i < 3; i++){
            arr[i] = sc.nextInt();
        }

        int sameNum = 0;    // 같은 숫자
        int sameCnt = 0;    // 같은 수 카운트
        int maxNum = 0;     // 최대 값
        for(int i = 0; i < 2; i++){
            for(int j = i + 1; j < 3; j++){
                
                if(arr[i] == arr[j]) {
                    sameNum = arr[i];
                    sameCnt++;
                }
                
                int tmp = Math.max(arr[i], arr[j]);
                
                if (tmp > maxNum){
                    maxNum = tmp;
                }
            }
        }

        if(sameCnt == 3){   // 모두 같을 때
            res = 10000 + (sameNum * 1000);
        }else if(sameCnt == 1){ // 두개만 같을 때
            res = 1000 + (sameNum * 100);
        } else {    // 모두 다를 때
            res = maxNum * 100;
        }
        System.out.println(res);

    }
}

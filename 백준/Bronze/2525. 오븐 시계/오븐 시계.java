import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 시작시간
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        // 걸린시간
        int dm = sc.nextInt();
        int dh = (minute + dm) / 60;

        // 끝나는 시간
        int resMinute = (minute + dm) % 60;
        int resHour = (hour + dh) % 24;
        System.out.printf("%d %d", resHour, resMinute);
    }

}

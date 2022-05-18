
import java.util.Scanner;

public class Main {

    public Main(String strs){

        int res = 0;
        Boolean isAfterMinus = false;
        StringBuffer sb = new StringBuffer();
        int tmp = 0;
        for(char ch : strs.toCharArray()){

            if(ch == '+' || ch == '-'){
                tmp = Integer.parseInt(sb.toString());
                sb = new StringBuffer();
                if(isAfterMinus){
                    res -= tmp;
                }else{
                    res += tmp;
                }
                isAfterMinus = ch == '-' ? true : isAfterMinus;
            }else{
                sb.append(ch);
            }

        }
        tmp = Integer.parseInt(sb.toString());
        if(isAfterMinus){
            res -= tmp;
        }else{
            res += tmp;
        }
        System.out.println(String.valueOf(res));
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        new Main(sc.nextLine());
    }
}

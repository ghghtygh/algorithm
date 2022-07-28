import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int now = 1;
        Boolean isSuccess = true;
        StringBuffer sb = new StringBuffer();
        loop1:for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (stack.empty() || stack.peek() < tmp) {
                loop2:
                while (stack.empty() || stack.peek() < tmp) {
                    if (now > tmp) {
                        isSuccess = false;
//                        System.out.println("실패1");
                        break loop1;
                    } else {
                        stack.push(now++);
//                        System.out.println("+");
                        sb.append("+").append("\n");
                    }
                }
            }

            if (stack.peek() == tmp) {
                stack.pop();
//                System.out.println("-");
                sb.append("-").append("\n");
            } else {
                isSuccess = false;
//                System.out.println("실패2");
                break loop1;
            }

        }

        if (isSuccess) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}

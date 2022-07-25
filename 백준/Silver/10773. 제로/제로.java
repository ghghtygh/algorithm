import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        long sum = 0L;
        while (K-- > 0) {
            String str = br.readLine();
            if ("0".equals(str)) {
                sum -= stack.pop();
            } else {
                int tmp = Integer.parseInt(str);
                stack.add(tmp);
                sum += tmp;
            }
        }
        System.out.println(sum);
    }
}

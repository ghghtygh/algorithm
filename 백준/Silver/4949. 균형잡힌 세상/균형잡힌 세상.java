import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Stack<Character> stack1;
        boolean isSuccess;
        StringBuffer sb = new StringBuffer();
        while (!(str = br.readLine()).equals(".")) {
            stack1 = new Stack<Character>();
            isSuccess = true;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                switch (ch) {
                    case '(':
                    case '[':
                        stack1.add(ch);
                        break;
                    case ')':
                        if (stack1.size() <= 0) {
                            isSuccess = false;
                        } else {
                            char tmp = stack1.pop();
                            if (tmp != '(') {
                                isSuccess = false;
                            }
                        }
                        break;
                    case ']':
                        if (stack1.size() <= 0) {
                            isSuccess = false;
                        } else {
                            char tmp = stack1.pop();
                            if (tmp != '[') {
                                isSuccess = false;
                            }
                        }
                        break;
                }

                if (!isSuccess) {
                    break;
                }
            }

            sb.append(isSuccess && stack1.size() == 0 ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}

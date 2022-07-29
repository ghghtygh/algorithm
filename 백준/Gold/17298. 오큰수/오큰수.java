import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        int[] arr2 = new int[N];
        Arrays.fill(arr2, -1);

        Stack<Integer> stack = new Stack<>();   // 오큰수가 정해지지 않은 인덱스를 저장할 스택

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (arr[i] > arr[stack.peek()]) {
                    arr2[stack.pop()] = arr[i];
                } else {
                    break;
                }
            }
            stack.push(i);

            /*for (int j = 0; j < i; j++) {
                if (arr2[j] == -1 && arr[i] > arr[j]) {
                    arr2[j] = arr[i];
                }
            }*/
        }
        StringBuffer sb = new StringBuffer();
        for (int i : arr2) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

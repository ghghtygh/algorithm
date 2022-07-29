import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int[] arr;

    private int f = 0;
    private int b = 0;

    public Main() {
        arr = new int[2000000];
    }

    public Main(int N) {
        arr = new int[N];
    }

    public void push(int X) {
        arr[b++] = X;
    }

    public int pop() {
        return empty() == 1 ? -1 : arr[f++];
    }

    public int size() {
        return b - f;
    }

    public int empty() {
        return f == b ? 1 : 0;
    }

    public int front() {
        return empty() == 1 ? -1 : arr[f];
    }

    public int back() {
        return empty() == 1 ? -1 : arr[b - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Main stack = new Main(N);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "front":
                    sb.append(stack.front()).append("\n");
                    break;
                case "back":
                    sb.append(stack.back()).append("\n");
                    break;

            }
        }

        System.out.println(sb);
    }
}

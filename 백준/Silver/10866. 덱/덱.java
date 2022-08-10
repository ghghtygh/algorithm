import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private Integer[] arr;
    private int fi;
    private int bi;

    public Main() {
        arr = new Integer[20001];
        fi = 10000;
        bi = 10000;
    }

    public Main(int N) {
        arr = new Integer[(N * 2) + 1];
        fi = N;
        bi = N;
    }

    // 정수 X를 덱의 앞에 넣음
    public void push_front(int X) {
        arr[fi--] = X;
    }

    // 정수 X를 덱의 뒤에 넣음
    public void push_back(int X) {
        arr[++bi] = X;
    }

    // 덱의 가장 앞에 수 반환, 없을시 -1
    public int pop_front() {
        return empty() == 1 ? -1 : arr[++fi];
    }

    // 덱의 가장 뒤에 수 반환, 없을시 -1
    public int pop_back() {
        return empty() == 1 ? -1 : arr[bi--];
    }

    // 덱에 들어있는 정수 개수
    public int size() {
        return bi - fi;
    }

    // 덱 비어있으면 1, 아니면 0
    public int empty() {
        return fi == bi ? 1 : 0;
    }

    // 덱의 가장 앞 정수 출력
    public int front() {
        return empty() == 1 ? -1 : arr[fi + 1];
    }

    // 덱의 가장 뒤 정수 출력
    public int back() {
        return empty() == 1 ? -1 : arr[bi];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Main deque = new Main(N);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}

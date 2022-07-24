import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int size = 0;
    private int[] arr;

    public Main(int N){
        arr = new int[N+1];
    }

    public void push(int X) {
        arr[++size] = X;
    }

    public int pop() {
        if (size <= 0) {
            return -1;
        }

        return arr[size--];
    }
    public int size() {
        return size;
    }

    public int empty() {
        return size <= 0 ? 1 : 0;
    }

    public int top() {
        if (size <= 0) {
            return -1;
        }
        return arr[size];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Main main = new Main(N);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String word = st.nextToken();

            switch (word) {
                case "push":
                    main.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(main.pop()).append("\n");
                    break;
                case "size":
                    sb.append(main.size()).append("\n");
                    break;
                case "empty":
                    sb.append(main.empty()).append("\n");
                    break;
                case "top":
                    sb.append(main.top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue1 = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            queue1.add(i);
        }

        sb.append("<");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < K; j++) {
                queue1.add(queue1.poll());
            }
            sb.append(queue1.poll());
            if (i < N) {
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }
        System.out.println(sb);
    }
}

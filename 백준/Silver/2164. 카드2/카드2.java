import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue1 = new ArrayDeque<Integer>();

        for (int i = 1; i <= N; i++) {
            queue1.add(i);
        }

        if (N > 1) {
            queue1.poll();
        }
        while (queue1.size() > 1) {
            int tmp = queue1.poll();
            queue1.add(tmp);
            queue1.poll();
        }
        System.out.println(queue1.peek());
    }
}

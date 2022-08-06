import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 찾는 문서 인덱스

            Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<int[]> aQueue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                Integer tmp = Integer.parseInt(st.nextToken());
                pQueue.add(tmp);
                aQueue.add(new int[]{i, tmp});
            }

            for (int i = 1; i <= N; i++) {
                int[] tmp = aQueue.peek();
                loop2:for (int j = i; j <= N; j++) {
                    tmp = aQueue.poll();
                    if(pQueue.peek() <= tmp[1]){
                        pQueue.poll();
                        break loop2;
                    }else {
                        aQueue.add(tmp);
                    }
                }
                if (tmp[0] == M) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            /*
            getBn(N, M) = getBn(N-1, M-1) + getBn(N-1, M)

            M == 0 || N == M -> 1
            N == 1
N
0            1
1           1 1
2          1 2 1
          1 3 3 1
         1 4 6 4 1
       1 5 10 10 5 1
      1 6 15 20 15 6 1
     1 7 21 35 35 21 7 1
    1 8 28 56 70 56 28 8 1
            nCm = n!  / (n-m)! * m!

            n! 2의 개수 - (n-m)! 2의개수 - m! 2의개수
            n! 5의 개수 - (n-m)! 5의개수 - m! 5의개수
            둘중 최소값
            */
            long cnt2 = getCntDivNum(N, 2) - getCntDivNum(N-M, 2) - getCntDivNum(M, 2);
            long cnt5 = getCntDivNum(N, 5) - getCntDivNum(N-M, 5) - getCntDivNum(M, 5);

            System.out.println(Math.min(cnt2, cnt5));

        } catch(IOException e){ }
    }

    public static long getCntDivNum(long N, long D){
        long cnt = 0;

        /*
        for(long i = N; i >= 2; i--){
            long t = i;
            while(t >= D && t % D == 0){
                t /= D;
                cnt++;
            }
        }
        */
        while(N >= D){
            cnt += (N / D);
            N /= D;
        }

        return cnt;
    }
}

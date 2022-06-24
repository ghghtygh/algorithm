import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static HashSet<Integer> allSet;
    static int N;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            N = Integer.parseInt(br.readLine());

            arr = new int[N+1][N+1];
            Integer[] alls = new Integer[N];
            StringTokenizer st;
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 1; j <= N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                alls[i-1] = i;
            }

            allSet = new HashSet<>(Arrays.asList(alls));
            boolean[] visited = new boolean[N + 1];
            Arrays.fill(visited, false);
            recur(new Integer[N/2], visited,0, 0);

            System.out.println(min);

        } catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static void recur(Integer[] teamArr, boolean[] visited, int idx, int depth){

        if(depth >= N/2){

            HashSet<Integer> set1 = new HashSet<>(Arrays.asList(teamArr));
            HashSet<Integer> set2 = new HashSet<>();
            set2.addAll(allSet);
            set2.removeAll(set1);

            diffScoreBySet(set1, set2);
            return;
        }

        for(int i = 1+idx; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                teamArr[depth] = i;
                recur(teamArr, visited, i,depth+1);
                visited[i] = false;
            }
        }
    }
    public static void diffScoreBySet(HashSet<Integer> set1, HashSet<Integer> set2){

        Integer[] tmpArr1 = new Integer[N/2];
        Integer[] tmpArr2 = new Integer[N/2];

        long sum1 = subScoreByArr(set1.toArray(tmpArr1));
        long sum2 = subScoreByArr(set2.toArray(tmpArr2));

        long diff = Math.abs(sum1 - sum2);

        if(diff < min){
            min = diff;
        }

    }
    public static long subScoreByArr(Integer[] arr1){

        long sum = 0;

        for(int i = 0; i < N/2; i++){
            for(int j = 0; j < N/2; j++){
                if(i != j){
                    int x = arr1[i];
                    int y = arr1[j];
                    sum += arr[x][y];
                }
            }
        }

        return sum;
    }
}

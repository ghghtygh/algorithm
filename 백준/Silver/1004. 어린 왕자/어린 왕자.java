import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){

            int N = Integer.parseInt(br.readLine());

            StringBuffer sb = new StringBuffer();
            Main main = new Main();

            for(int i = 0; i < N; i++){
                int[][] arr1 = new int[2][2];
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                arr1[0][0] = Integer.parseInt(st1.nextToken());
                arr1[0][1] = Integer.parseInt(st1.nextToken());
                arr1[1][0] = Integer.parseInt(st1.nextToken());
                arr1[1][1] = Integer.parseInt(st1.nextToken());

                int M = Integer.parseInt(br.readLine());
                int[][] arr2 = new int[M][3];
                for(int j = 0; j < M; j++){
                    st1 = new StringTokenizer(br.readLine(), " ");
                    arr2[j][0] = Integer.parseInt(st1.nextToken());
                    arr2[j][1] = Integer.parseInt(st1.nextToken());
                    arr2[j][2] = Integer.parseInt(st1.nextToken());
                }
                sb.append(main.solution(arr1, arr2)).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e){

        }
    }
    public int solution(int[][] arr1, int[][] arr2){

        int N = arr2.length;
        int res = 0;
        for(int i = 0; i < N; i++){
            int[] st = arr1[0];
            int[] ed = arr1[1];

            int[] ar2 = arr2[i];
            int r = ar2[2];

            Boolean tmp1 = isAInnerB(st, ar2, r);
            Boolean tmp2 = isAInnerB(ed, ar2, r);

            // 첫번째 좌표 내 은하계 && 두번째 좌표 내 은하계
            // 첫번째 좌표 외 은하계 && 두번째 좌표 외 은하계
            if(tmp1 && tmp2 || (!tmp1 && !tmp2)){
                continue;
            } else{
                res += 1;
            }

        }

        return res;
    }
    public boolean isAInnerB(int[] arr1, int[] arr2, int r){

        //System.out.printf("기준 좌표 : (%d,%d)\n",arr1[0],arr1[1]);
        //System.out.printf("은하계 좌표 : (%d,%d)\n",arr2[0],arr2[1]);
        //System.out.printf("반지름 : %d\n", r);
        int dt = (int) (Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2));

        if(dt <= Math.pow(r, 2)){
            return true;
        }else{
            return false;
        }
    }

}

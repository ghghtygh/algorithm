import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int N = Integer.parseInt(br.readLine());

            int[] X = new int[6];
            int[] Y = new int[6];

            StringTokenizer st;

            int x = 2000;
            int y = 2000;

            int maxX = x;
            int minX = x;

            int maxY = y;
            int minY = y;

            for(int i = 0; i < 6; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int bh = Integer.parseInt(st.nextToken());
                int mnt = Integer.parseInt(st.nextToken());
                int m = -1; // 서 남
                if(bh == 1 || bh == 4){ // 동 북
                    m = 1;
                }

                // 동 서
                if(bh <= 2){
                    x = (mnt * m) + x;
                }else{ // 남 북
                    y = (mnt * m) + y;
                }

                if(maxX < x){
                    maxX = x;
                }

                if(minX > x){
                    minX = x;
                }

                if(maxY < y){
                    maxY = y;
                }
                if(minY > y){
                    minY = y;
                }
                X[i] = x;
                Y[i] = y;
            }

            Boolean[] arr = new Boolean[4];
            Arrays.fill(arr, false);
            for(int i = 0; i < 6; i++){
                if(X[i] == minX){
                    if(Y[i] == minY){
                        arr[2] = true;
                    }else if(Y[i] == maxY){
                        arr[1] = true;
                    }
                } else if (X[i]==maxX){
                    if(Y[i]==minY){
                        arr[3] = true;
                    }else if(Y[i]==maxY){
                        arr[0] = true;
                    }
                }
            }

            Arrays.sort(X);
            Arrays.sort(Y);

            int grnd = (maxX - minX) * (maxY - minY);

            if(arr[0] == false){
                grnd = grnd - ((maxX - X[3]) * (maxY - Y[3]));
            }else if(arr[1]==false){
                grnd = grnd - ((X[3] - minX) * (maxY - Y[3]));
            }else if(arr[2]==false){
                grnd = grnd - ((X[3] - minX) * (Y[3] - minY));
            }else{
                grnd = grnd - ((maxX - X[3]) * (Y[3] - minY));
            }

            System.out.println(N * grnd);
        } catch(IOException e){

        }
    }
}

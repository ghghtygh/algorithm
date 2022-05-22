public class Main {

    int N = 10000;
    int[] arr;
    public Main(){
        arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            solution(i, 0);
        }

        for(int i = 1; i <= N; i++){
            if(arr[i] == 0)
                System.out.println(i);
        }
    }
    public void solution(int idx, int i){

        if(arr[idx] > 0){
            return;
        }

        if(i > 0){
            arr[idx] = 1;
        }
        int nextNum = idx;
        while(idx > 0){
            nextNum += (idx % 10);
            idx /= 10;
        }

        if(nextNum > N){
            return;
        }

        solution(nextNum, 1);
    }
    public static void main(String[] args){
        new Main();
    }
}

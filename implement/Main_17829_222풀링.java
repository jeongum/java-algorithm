package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17829_222풀링 {
    static int[][] arr ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i =0 ; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pulling(N);

        System.out.println(arr[0][0]);
    }

    public static void pulling(int size){
        if(size == 1) return;
        for(int i =0 ; i < size ; i += 2){
            for(int j =0 ; j < size ; j += 2){
                int[] tmp = {arr[i][j], arr[i][j+1], arr[i+1][j], arr[i+1][j+1]};
                Arrays.sort(tmp);
                arr[i/2][j/2] = tmp[2];
            }
        }
        pulling(size/2);
    }
}

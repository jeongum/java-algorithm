package bruteForce;

import java.util.*;
import java.io.*;

public class BOJ_18429_근손실 {
    static int N, K, cnt = 0;
    static int[] kit;
    static boolean[] used;
    static int[] kitNum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        kitNum = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }
        doExercise(0, 500);
        System.out.println(cnt);
    }

    private static void doExercise(int day, int weight) {
        if(weight < 500) return;
        if(day == N){
            cnt++; return;
        }
        for(int i = 0 ; i < N ; i++){
            if(used[i]) continue;
            used[i] = true;
            kitNum[day] = i;
            doExercise(day+1, weight+kit[i]-K);
            used[i] = false;
        }
    }
}


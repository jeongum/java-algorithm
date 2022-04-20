package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    static int R, C, cnt=0;
    static char[][] arr;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean[] alpha ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        alpha = new boolean[26];
        for(int i =0 ; i < R ; i++) {
            String str = br.readLine();
            arr[i] = str.toCharArray();
        }
        move(0,0,0);
        System.out.println(cnt);
    }

    private static void move(int ci, int cj, int depth) {
        if(alpha[arr[ci][cj] - 'A']) {      // 이미 방문을 했던 곳이라면 > 탐색 끝
            cnt = Math.max(cnt, depth);
            return ;
        }
        alpha[arr[ci][cj] - 'A'] = true;    // 방문 표시
        for(int i =0 ; i < 4 ; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];
            if(0<=ni&&ni<R && 0<=nj&&nj<C) {
                move(ni,nj,depth+1);
            }
        }
        alpha[arr[ci][cj] - 'A'] = false;   // 방문 false 처리
    }
}
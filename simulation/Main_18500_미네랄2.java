package simulation;

import java.io.*;
import java.util.*;

public class Main_18500_미네랄2 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int R, C;
    static boolean[][] mineral;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mineral = new boolean[R][C];
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j =0 ;j < C ; j++){
                mineral[i][j] = str.charAt(j) == '.'?false:true;
            }
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            int stick = R-Integer.parseInt(st.nextToken());
            attack(i%2, stick);
        }

        StringBuilder sb =new StringBuilder();
        for(int i =0 ; i < R ; i++){
            for(int j = 0 ;j < C ; j++){
                sb.append((mineral[i][j])?'x':'.');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean[][] visited ;
    static List<int[]> cluster ;
    private static void attack(int dir, int stick) {
        int pos;
        if(dir == 0) {
            pos = -1;
            while (++pos < C && !mineral[stick][pos]) ;
            if (pos >= C) return;
        } else{
            pos = C;
            while(--pos >= 0 && !mineral[stick][pos]);
            if(pos < 0 ) return;
        }
        mineral[stick][pos] = false;
        visited  = new boolean[R][C];
        cluster = new ArrayList<>();
        boolean flag = false;
        if(pos-1 >= 0 && mineral[stick][pos-1] && !visited[stick][pos-1] && !isConnected(stick, pos-1)){
            getDown(stick );
        }
        else if(pos+1 < C && mineral[stick][pos+1] && !visited[stick][pos+1] && !flag){
            flag = isSeperate(stick, pos+1);
        }
        else if(stick-1 >= 0 && mineral[stick-1][pos] && !visited[stick][pos] && !flag){
            flag =
        }
    }

    private static void doRightAttack(int stick) {
        int pos = C;
        boolean rightUp = false, nextLeft = false;
        while(--pos >= 0 && !mineral[stick][pos]);
        if(pos < 0 ) return;
        mineral[stick][pos] = false;
        if(stick - 1 >= 0 && mineral[stick-1][pos]){   //  위-오른쪽 탐색
            rightUp = destroy(1, stick-1, pos);
        }
        if(pos - 1 >= 0 && mineral[stick][pos-1]){
            nextLeft = destroy(0, stick, pos-1);
        }
        if(!rightUp && !nextLeft) getDown(stick);
    }

    private static void getDown(int height) {
        int newH =0 ;
        for(int i = height; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(mineral[newH][j]) break;
            }
        }
        newH--;
        out2:for(int i = 0 ; newH-i-1 >= 0; i++){
            for(int j = 0 ; j < C ; j++){
                if(newH-i == R-1 && mineral[newH-i][j]) continue;
                mineral[newH-i][j] = mineral[newH-i-1][j];
            }
        }
        Arrays.fill(mineral[0], false);
    }

    private static boolean isConnected(int dStick, int dPos) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{dStick, dPos});
        boolean[][] visited = new boolean[R][C];
        visited[dStick][dPos] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int i = tmp[0];
            int j = tmp[1];
            if(i > dStick) return true;
            for(int d = 0 ; d < 3 ; d++){
                int ni = i + di[dir][d];
                int nj = j + dj[dir][d];
                if(dir == 0 && 0<=ni&&ni<R && 0<=nj&&nj<dPos){
                    if(!visited[ni][nj] && mineral[ni][nj]){
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
                else if(dir == 1 && 0<=ni&&ni<R && dPos<=nj&&nj<C){
                    if(!visited[ni][nj] && mineral[ni][nj]){
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        return false;
    }
}

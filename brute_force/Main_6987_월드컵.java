package brute_force;

import java.util.*;
import java.io.*;

public class Main_6987_월드컵 {
    static final int T = 4;     // 테스트 케이스 수
    static int[][] game;
    static int[][] match = new int[15][2];   // A-BCDEF / B-CDEF ... 저장
    static boolean isPossible;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = i+1 ; j < 6 ; j ++){
                match[idx][0] = i;
                match[idx][1] = j;
                idx++;
            }
        }
        tc:for(int tc = 0 ; tc<T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            game = new int[6][3];

            for(int i = 0 ; i < 6 ; i++){
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());

                if(win + draw + lose != 5){ // 한 팀당 경기수가 5가 넘을 경우
                    System.out.print("0 "); continue tc;
                }

                game[i][0] = win;
                game[i][1] = draw;
                game[i][2] = lose;
            }
            isPossible = false;
            doGame(0);

            System.out.print(isPossible?"1 ":"0 ");
        }
    }


    /*
        만약 유효하지 않은 경기 결과라면, round 15회를 돌지 못한 채 끝남
     */
    private static void doGame(int round) {
        if(round == 15){    // 유효한 경기 결과
            isPossible = true;
            return;
        }

        int t1 = match[round][0];
        int t2 = match[round][1];

        // 각 팀에 승/패/무 cnt가 남아있어야 함
        if(game[t1][0] > 0 && game[t2][2] > 0){ // t1: 승 / t2: 패
            game[t1][0] --; game[t2][2] --;
            doGame(round+1);
            game[t1][0] ++; game[t2][2] ++; // 다시 돌려놓고 다음 경우 실행
        }

        if(game[t1][1] > 0 && game[t2][1] > 0){ // t1: 무 / t2: 무
            game[t1][1] --; game[t2][1] --;
            doGame(round+1);
            game[t1][1] ++; game[t2][1] ++;
        }

        if(game[t1][2] > 0 && game[t2][0] > 0){ // t1: 패 / t2: 승
            game[t1][2] --; game[t2][0] --;
            doGame(round+1);
            game[t1][2] ++; game[t2][0] ++;
        }
    }
}

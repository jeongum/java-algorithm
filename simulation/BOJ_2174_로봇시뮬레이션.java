package simulation;

import java.util.*;
import java.io.*;

public class BOJ_2174_로봇시뮬레이션 {
    static int[] di = {-1, 0 , 1, 0}; // N,W,S,E > 시계 반대 방향
    static int[] dj = {0, -1 , 0, 1}; // N,W,S,E > 시계 반대 방향
    static int A, B;
    static int N, M;
    static int[][] robots;
    static int[][] isThere;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new int[N][3];
        isThere = new int[B][A];

        for(int i =0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;         // J와 같으나, 0부터 시작하는 좌표계를 위해 -1
            int y = B-Integer.parseInt(st.nextToken());         // 문제와 반대로 y를 설정하기 위해, 주어진 높이에서 입력을 뺀 값을 최종 I 좌표로 설정
            int d = 0;
            switch (st.nextToken().charAt(0)){
                case 'N': d = 0; break;
                case 'W': d = 1; break;
                case 'S': d = 2; break;
                case 'E': d = 3; break;
            }
            robots[i] = new int[]{y, x, d};
            isThere[y][x] = i+1;        // Map에서 robot의 위치 설정
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int robot = Integer.parseInt(st.nextToken())-1;
            char inst = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());
            for(int j =0 ; j < cnt ; j++) {
                switch (inst) {
                    case 'L': {
                        robots[robot][2] = (robots[robot][2] + 1) % 4;      // 시계 반대 방향
                        break;
                    }
                    case 'R': {
                        robots[robot][2] = (robots[robot][2] - 1)<0 ? 3:(robots[robot][2] - 1); // 시계 방향
                        break;
                    }
                    case 'F': {
                        int ni = robots[robot][0] + di[robots[robot][2]];
                        int nj = robots[robot][1] + dj[robots[robot][2]];
                        if(0<=ni&&ni<B && 0<=nj&&nj<A){
                            if(isThere[ni][nj] == 0){   // 정상적인 명령 수행
                                isThere[robots[robot][0]][robots[robot][1]] = 0;
                                isThere[ni][nj] = robot+1;
                                robots[robot][0] = ni;
                                robots[robot][1] = nj;
                            } else if(isThere[ni][nj] != robot+1){  // 로봇과 충돌하면!
                                System.out.printf("Robot %d crashes into robot %d", robot+1, isThere[ni][nj]);
                                return;
                            }
                        } else{     // 벽에 닿으면!
                            System.out.printf("Robot %d crashes into the wall", robot+1);
                            return;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println("OK");
    }
}

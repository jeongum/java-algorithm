package simulation;

import java.util.*;
import java.io.*;

public class Main_17780_새로운게임 {
    static class Mark{
        int i, j, d;
        boolean isStacked;
        Deque<Integer> dirs = new ArrayDeque<>();
        public Mark(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {1, -1, 0, 0};
    static int N;
    static int[][] map;
    static List<Mark> marks;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i =0 ; i < N ; i++){
            st =new StringTokenizer(br.readLine());
            for(int j =0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        marks = new ArrayList<>();
        for(int i =0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            marks.add(new Mark(x, y, d));
            marks.get(i).dirs.add(i);
        }

        System.out.println(doGame());
    }

    private static int doGame() {
        int turn = 1;
        end: while(turn < 1000){
            for(Mark m:marks){
                if(m.isStacked) continue;
                int d = m.d;
                int ni = m.i + di[d];
                int nj = m.j + dj[d];
                if(ni<0||ni>=N||nj<0||nj>=N||map[ni][nj]==2){
                    int dir = m.d;
                    switch (dir){
                        case 0: m.d = 1; break;
                        case 1: m.d = 0; break;
                        case 2: m.d = 3; break;
                        case 3: m.d = 2; break;
                    }
                    dir = m.d;
                    ni = m.i + di[dir];
                    nj = m.j + dj[dir];
                    if(ni<0||ni>=N||nj<0||nj>=N) continue;
                }
                if(map[ni][nj] == 1){
                    Mark exist = isExist(ni, nj);
                    if(exist != null){
                        while(!m.dirs.isEmpty()){
                            exist.dirs.offerLast(m.dirs.pollLast());
                        }
                        if(exist.dirs.size() >= 4) break end;
                        m.isStacked = true;
                    }
                    else{
                        Deque<Integer> dq = new ArrayDeque<>();
                        Mark down = (m.dirs.isEmpty())? m : marks.get(m.dirs.peekLast());
                        m.isStacked = true;
                        while(!m.dirs.isEmpty()){
                            dq.offerLast(m.dirs.pollLast());
                        }
                        down.dirs = dq;
                        down.isStacked = false;
                        down.i = ni;
                        down.j = nj;
                    }
                }
                else if(map[ni][nj] == 0){
                    Mark exist = isExist(ni, nj);
                    if(exist != null){
                        while(!m.dirs.isEmpty()){
                            exist.dirs.offerLast(m.dirs.pollFirst());
                        }
                        if(exist.dirs.size() >= 4) break end;
                        m.isStacked = true;
                    }
                    else{
                        m.i = ni;
                        m.j = nj;
                    }
                }
            }
            turn ++;
        }
        return (turn>=1000)?-1:turn;
    }

    private static Mark isExist(int i, int j) {
        for(Mark m : marks){
            if(m.i == i && m.j == j && !m.isStacked) return m;
        }
        return null;
    }
}

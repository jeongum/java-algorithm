package simulation;

import java.util.*;
import java.io.*;

public class Main_17780_새로운게임 {
    static class Mark{
        int i, j;
        Deque<Integer> dirs = new ArrayDeque<>();
        public Mark(int i, int j) {
            this.i = i;
            this.j = j;
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
            marks.add(new Mark(x, y));
            marks.get(i).dirs.addLast(d);
        }

        System.out.println(doGame());
    }

    private static int doGame() {
        int turn = 0;
        end: while(turn < 1000){
            List<Mark> tmp = new ArrayList<>();
            for(int k = 0 ; k < marks.size() ; k++){
                Mark m = marks.get(k);
                int d = m.dirs.peekFirst();
                int ni = m.i + di[d];
                int nj = m.j + dj[d];
                if(ni<0||ni>=N||nj<0||nj>=N||map[ni][nj]==2){
                    int dir = m.dirs.pollFirst();
                    switch (dir){
                        case 0: m.dirs.offerFirst(1); break;
                        case 1: m.dirs.offerFirst(0); break;
                        case 2: m.dirs.offerFirst(3); break;
                        case 3: m.dirs.offerFirst(2); break;
                    }
                    dir = m.dirs.peekFirst();
                    ni = m.i + di[dir];
                    nj = m.j + dj[dir];
                    if(ni<0||ni>=N||nj<0||nj>=N){
                        tmp.add(m);
                        continue;
                    }
                }
                if(map[ni][nj] == 1){
                    Mark exist = isExist(ni, nj);
                    if(exist != null){
                        while(!m.dirs.isEmpty()){
                            exist.dirs.offerLast(m.dirs.pollLast());
                        }
                        if(exist.dirs.size() >= 4) break end;
                    }
                    else{
                        Deque<Integer> dq = new ArrayDeque<>();
                        while(!m.dirs.isEmpty()){
                            dq.offerLast(m.dirs.pollLast());
                        }
                        m.dirs = dq;
                        m.i = ni;
                        m.j = nj;
                        tmp.add(m);
                    }
                }
                else if(map[ni][nj] == 0){
                    Mark exist = isExist(ni, nj);
                    if(exist != null){
                        while(!m.dirs.isEmpty()){
                            exist.dirs.offerLast(m.dirs.pollFirst());
                        }
                        if(exist.dirs.size() >= 4) break end;
                    }
                    else{
                        m.i = ni;
                        m.j = nj;
                        tmp.add(m);
                    }
                }
            }
            turn ++;
            marks = tmp;
        }
        return (turn>=1000)?-1:turn;
    }

    private static Mark isExist(int i, int j) {
        for(Mark m : marks){
            if(m.i == i && m.j == j) return m;
        }
        return null;
    }
}

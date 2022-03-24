package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2933_미네랄 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int R, C;
    static boolean[][] mineral;
    static int N;
    static List<int[]> broken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mineral = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                mineral[i][j] = (str.charAt(j) == '.') ? false : true;
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = R-Integer.parseInt(st.nextToken());
            broken = new ArrayList<>();
            if(i%2==0){     // 왼쪽에서 공격
                int pos = 0;
                while(pos<C && !mineral[height][pos++]);            // 부실 미네랄의 j값 찾기
                if(pos >= C && !mineral[height][pos-1]) continue;
                mineral[height][--pos] = false;     // 부실 미네랄 false 처리
                if(pos < C-1 && height < R-1 && mineral[height][pos+1] && breakMineral(height, pos+1, height+1)) fallMineral();     // 오른쪽 탐색
                else if(pos < C && height > 0 && mineral[height-1][pos] &&breakMineral(height-1, pos, height)) fallMineral();   // 위쪽 탐색
                else if(pos < C && height < R-1 && mineral[height+1][pos] &&breakMineral(height+1, pos, height)) fallMineral(); // 아래쪽 탐색
            }
            else if(i%2 == 1){  // 오른쪽에서 공격
                int pos = C-1;
                while(pos>=0 && !mineral[height][pos--]);   // 부실 미네랄 j값 찾기
                if(pos < 0 && !mineral[height][pos+1]) continue;
                mineral[height][++pos] = false;
                if(pos > 0 && height < R-1 && mineral[height][pos-1] && breakMineral(height, pos-1, height+1)) fallMineral();   // 왼쪽 탐색
                else if(pos >= 0 && height > 0 && mineral[height-1][pos] && breakMineral(height-1, pos, height)) fallMineral(); // 위쪽 탐색
                else if(pos >= 0 && height < R-1 && mineral[height+1][pos] && breakMineral(height+1, pos, height)) fallMineral();   // 아래쪽 탐색
            }
        }

        for(int i =0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                System.out.print((mineral[i][j])?'x':'.');
            }
            System.out.println();
        }
    }

    private static void fallMineral() {
        out:while(true) {
            boolean[][] tmpMin = new boolean[R][C];
            for(int i =0 ; i < R ; i++) tmpMin[i] = Arrays.copyOf(mineral[i], C);   // 떨어질 미네랄을 체크하지 않도록 임시 배열 만들어 줌
            for(int[] c : broken) tmpMin[c[0]][c[1]] = false;   // 떨어질 미네랄 자리를 false
            for(int[] c : broken) {
                if (c[0]+1 >= R || tmpMin[c[0]+1][c[1]]) {  // 모든 원소가 아래로 한칸씩 떨어질 수 있는지 판별
                    break out;
                }
            }
            // 한칸씩 떨어질 수 있다!
            for(int[] c : broken) mineral[c[0]][c[1]] = false;  // 기존의 미네랄 자리를 먼저 false 처리 -> 나중에 겹칠 위험 있음
            for(int i =0 ; i < broken.size() ; i++){
                int[] tmp = broken.get(i);
                mineral[tmp[0]+1][tmp[1]] = true;   // 새로운 자리 true
                broken.set(i, new int[]{tmp[0]+1, tmp[1]}); // 한칸 아래로 내려간 인덱스로 다시 저장
            }
        }
    }

    private static boolean breakMineral(int i, int j, int height) {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        broken.add(new int[]{i, j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d= 0 ; d < 4 ; d++){
                int ni = cur[0]+di[d];
                int nj = cur[1]+dj[d];
                if(0<=ni&&ni<R && 0<=nj&&nj<C && mineral[ni][nj] && !visited[ni][nj]){
                    if(ni == R-1){      // 바닥과 맞닿아 있는 곳이 있으면 안 떨어지는 거임
                        broken.clear();
                        return false;
                    }
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    broken.add(new int[]{ni, nj});
                }
            }
        }
        return true;
    }
}

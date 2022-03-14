package simulation;

import java.io.*;
import java.util.*;
public class Main_12100_2048easy {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int N;
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i =0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        play2048(0, map, false);
        System.out.println(res);
    }

    private static void play2048(int cnt, int[][] map, boolean isSame) {
        if(isSame || cnt == 5){
            for(int i =0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    res = Math.max(map[i][j], res);
                }
            }
            return;
        }

        // Up
        int[][] tmp = new int[N][N];    // 실제 움직일 배열
        for(int i = 0 ; i < N ; i++){
            int k = 0;
            boolean isSum = false;
            for(int j = 0 ; j < N ; j++){
                if(map[j][i] == 0) continue;
                if((j+1)<N && map[j][i] == map[j+1][i] ){
                    tmp[k++][i] = map[j++][i] * 2;
                    continue;
                } else if((j+1)<N && map[j+1][i] == 0 ){
                    int tmpJ = j+1;
                    while((tmpJ+1)<N && map[tmpJ+1][i] == 0 ) tmpJ++;
                    if(tmpJ + 1 < N &&map[j][i] == map[tmpJ + 1][i]){
                        tmp[k++][i] = map[tmpJ + 1][i] * 2;
                        j = tmpJ + 1;
                        continue;
                    }
                }
                tmp[k++][i] = map[j][i];
            }
        }
        play2048(cnt+1, tmp, isSame(tmp, map));

        // Right
        tmp = new int[N][N];    // 실제 움직일 배열
        for(int i = 0 ; i < N ; i++){
            int k = N-1;
            for(int j = N-1 ; j >= 0 ; j--){
                if(map[i][j] == 0) continue;
                if((j-1)>=0 && map[i][j-1] == map[i][j]){
                    tmp[i][k--] = map[i][j--] * 2;
                    continue;
                } else if((j-1)>=0 && map[i][j-1] == 0){
                    int tmpJ = j-1;
                    while((tmpJ-1)>=0 && map[i][tmpJ-1] == 0 ) tmpJ--;
                    if(tmpJ - 1 >= 0 && map[i][j] == map[i][tmpJ-1]){
                        tmp[i][k--] = map[i][tmpJ-1] * 2;
                        j = tmpJ-1;
                        continue;
                    }
                }
                tmp[i][k--] = map[i][j];
            }
        }
        play2048(cnt+1, tmp, isSame(tmp, map));

        // Down
        tmp = new int[N][N];    // 실제 움직일 배열
        for(int i = 0 ; i < N ; i++){
            int k = N-1;
            for(int j = N-1 ; j >= 0 ; j--){
                if(map[j][i] == 0) continue;
                if((j-1)>=0 && map[j-1][i] == map[j][i] ){
                    tmp[k--][i] = map[j--][i] * 2;
                    continue;
                } else if((j-1)>=0 && map[j-1][i] == 0){
                    int tmpJ = j-1;
                    while((tmpJ-1)>=0 && map[tmpJ-1][i] == 0 ) tmpJ--;
                    if(tmpJ - 1 >= 0 &&map[j][i] == map[tmpJ-1][i]){
                        tmp[k--][i] = map[tmpJ-1][i] * 2;
                        j = tmpJ-1;
                        continue;
                    }
                }
                tmp[k--][i] = map[j][i];
            }
        }
        play2048(cnt+1, tmp, isSame(tmp, map));

        // Left
        tmp = new int[N][N];    // 실제 움직일 배열
        for(int i = 0 ; i < N ; i++){
            int k = 0;
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 0) continue;
                if((j+1)<N && map[i][j] == map[i][j+1] ){
                    tmp[i][k++] = map[i][j++] * 2;
                    continue;
                } else if((j+1)<N && map[i][j+1] == 0 ){
                    int tmpJ = j+1;
                    while((tmpJ+1)<N && map[i][tmpJ+1] == 0 ) tmpJ++;
                    if(tmpJ + 1 < N && map[i][j] == map[i][tmpJ + 1]){
                        tmp[i][k++] = map[i][tmpJ + 1] * 2;
                        j = tmpJ + 1;
                        continue;
                    }
                }
                tmp[i][k++] = map[i][j];
            }
        }
        play2048(cnt+1, tmp, isSame(tmp, map));
    }

    private static boolean isSame(int[][] tmp, int[][] map) {
        for(int i =0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(tmp[i][j] != map[i][j]) return false;
            }
        }
        return true;
    }
}

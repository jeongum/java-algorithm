package graphTraversal;

import java.util.*;
import java.io.*;

public class BOJ_1765_닭싸움팀정하기 {
    static char[][] relation;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        relation = new char[N][N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char r = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken()) - 1;
            int q = Integer.parseInt(st.nextToken()) - 1;
            relation[p][q] = r;
            relation[q][p] = r;
        }

        int result = 0;
        for(int i =0 ; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                makeRelation(i);
                result++;
            }
        }
        System.out.println(result);
    }

    private static void makeRelation(int target) {
        for(int i = 0 ; i < N ; i++){
            if(visited[i]) continue;
            if(relation[target][i] == 'E'){
                for(int j = 0 ; j < N ; j++){
                    if(!visited[j] && j != target && relation[i][j] == 'E'){
                        visited[j] = true;
                        makeRelation(j);
                    }
                }
            }
            else if(relation[target][i] == 'F'){
                visited[i] = true;
                makeRelation(i);
            }
        }
    }
}

package shortestPath;

import java.util.*;
import java.io.*;

public class Main_11780_플로이드 {
    static final int INF = 10000001;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];    // 최단경로 저장
        int[][] path = new int[n+1][n+1];   // 도착점으로 가기 직전에 들린 점 저장


        for(int i = 0 ; i < n+1 ; i++){
            for(int j = 0 ; j < n + 1 ; j++){
                if(i == j){
                    map[i][j] = 0;
                    path[i][j] = INF;
                }else{
                    map[i][j] = INF;
                    path[i][j] = INF;
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], cost);  // 이미 저장되어 있을 지 모르니까, 최솟값 저장
            path[start][end] = start;
        }

        for(int k =1 ; k < n+1 ; k ++){
            for(int i = 1; i < n+1 ; i++){
                for(int j = 1 ; j < n+1 ; j++){
                    if(i!=j && map[i][j] > map[i][k] + map[k][j]){  // 바로 오는 길(map[i][j])보다 경로 k를 거쳐서 오는 길(map[i][k] + map[k][j])이 더 빠를 경우
                        map[i][j] = map[i][k] + map[k][j];  // 최소 비용 저장
                        path[i][j] = path[k][j];    // 도착점 j로 가기 전에, 들른 곳(path[k][j]) 저장
                    }
                }
            }
        }

        for(int i = 1 ; i < n +1 ; i++){
            for(int j = 1; j < n+1 ; j++){
                sb.append(map[i][j]==INF ? 0+" " : map[i][j]+" ");  // 최소 비용 출력
            }
            sb.append("\n");
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(path[i][j] == INF) sb.append("0\n"); // 갈 수 없는 경우
                else{
                    int end = j;
                    stack.push(end);
                    /*
                        i->j 경로라고 할 경우,
                        j전에 들렸던 곳을 계속해서 타고 가서
                        i를 만날때까지 스택에 넣으며 반복하는 로직
                        => 마지막 도착점부터 시작점까지 타고 거꾸로 타고 감
                     */
                    while( i != path[i][end] ){
                        end = path[i][end];
                        stack.push(end);
                    }
                    stack.push(i);  // 마지막인 시작점도 출력해야 하므로!
                    sb.append(stack.size());
                    while(!stack.isEmpty()){    // 시작점부터 마지막점까지 출력(stack > FILO)
                        sb.append(" "+stack.pop());
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

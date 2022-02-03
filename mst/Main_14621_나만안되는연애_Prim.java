package mst;

import java.util.*;
import java.io.*;

public class Main_14621_나만안되는연애_Prim {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] network = new int[N][N];
        boolean[] gender = new boolean[N];
        boolean[] visited = new boolean[N];
        int[] minVer = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N; i++){
            gender[i] = st.nextToken().charAt(0) == 'W'? true:false;
        }

        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            if(network[x][y] != 0){
                network[x][y] = Integer.min(network[x][y], c);
                network[y][x] = Integer.min(network[x][y], c);
            }
            else{
                network[x][y] = c;
                network[y][x] = c;
            }
        }

        Arrays.fill(minVer, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        int cnt = 0 , result = 0;
        minVer[0] = 0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            result += cur[1];

            if(cnt++ == N-1) break;

            for(int i =0 ; i < N ; i++){
                if(!visited[i] && network[cur[0]][i] != 0 && gender[cur[0]]!=gender[i]){
                    if(minVer[i] > network[cur[0]][i]){
                        minVer[i] = network[cur[0]][i];
                        pq.offer(new int[]{i, network[cur[0]][i]});
                    }
                }
            }
        }

        System.out.println(cnt!=N?-1:result);


    }
}

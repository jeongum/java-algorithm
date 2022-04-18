package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_1800_인터넷설치 {
    static int N, P, K;
    static List<int[]>[] connect;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        connect = new List[N];
        for(int i = 0 ; i < N ; i++) connect[i] = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i < P ; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken())-1;
            int f = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            connect[t].add(new int[]{f, c});
            connect[f].add(new int[]{t, c});
            max = Math.max(max, c);
        }

        int left = 0;       // 정답이 될 수 있는 최솟값
        int right = max;    // 정답이 될 수 있는 최댓값
        int res = Integer.MIN_VALUE;
        while(left <= right){   // 종료 조건: 왼쪽 포인터가 오른쪽 포인터보다 크거나 같아질 때
            int mid = (left+right) / 2; // 중간값 설정
            if(connectOK(mid)){ // mid 값이 답이 될 수 있다면
                res = mid;  // 일단 답으로 설정
                right = mid - 1;    // 좀 더 작은 값은 안되는지 다시 검사
            } else{ // 답이 안된다면
                left = mid + 1; // 좀 더 큰 값으로 다시 검사
            }
        }
        System.out.println((res == Integer.MIN_VALUE)?-1:res);
    }

    private static boolean connectOK(int mid) {
        int[] dist = new int[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int n = cur[0];
            int c = cur[1];

            if(dist[n] < c) continue;

            for(int[] i : connect[n]){
                int cost = (i[1] > mid)? c+1 : c;   // K보다 크면 +1, 안크면 0
                if(cost < dist[i[0]]){
                    dist[i[0]] = cost;
                    pq.offer(new int[]{i[0], cost});
                }
            }
        }
        return dist[N-1] <= K;  // dist[N-1] == K보다 큰 비용 경로의 개수
    }
}

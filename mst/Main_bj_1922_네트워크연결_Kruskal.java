package mst;

import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    int x, y, cost;
    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main_bj_1922_네트워크연결_Kruskal {
    static int N, M;
    static Edge[] network;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        network = new Edge[M];
        StringTokenizer st = null;
        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            network[i] = new Edge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(network);

        makeSet();

        int cnt = 0 , result = 0;
        for(Edge n:network){
            if(unionSet(n.x, n.y)){
                result += n.cost;
                if(++cnt == N-1) break;
            }
        }

        System.out.println(result);
    }

    private static boolean unionSet(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px == py) return false;
        parent[py] = px;
        return true;
    }

    private static int findParent(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    private static void makeSet() {
        for(int i =0 ; i < N ; i++) parent[i] = i;
    }
}

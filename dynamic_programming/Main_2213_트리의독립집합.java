package dynamic_programming;
import java.io.*;
import java.util.*;
public class Main_2213_트리의독립집합 {
    static int n;
    static int[] cost;
    static boolean[] selected;
    static int[][] dp;
    static List<Integer>[] adjacent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n];
        selected = new boolean[n];
        adjacent = new ArrayList[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            adjacent[i] = new ArrayList<>();
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            adjacent[to].add(from);
            adjacent[from].add(to);
        }

        int notin = indSet(0,0);
        int in = indSet(0,1);

        if(notin > in) selected[0] = false;
        else selected[0] = true;

        System.out.println(Math.max(notin, in));
        for(int i =0 ; i < n ; i++){
            if(selected[i]) System.out.print(i+" ");
        }
    }

    private static int indSet(int node, int include) {
        int result = 0;
        if(include == 0){   // 포함 안했을 때
            for(int i : adjacent[node]){
                int in = indSet(i, 1);
                int notin = indSet(i, 0);
                if(in > notin){
                    selected[i] = true;
                }else{
                    selected[i] = false;
                }
                result += Math.max(in, notin);
            }
            return result;
        }
        else{   // 포함 했을 때
            for(int i : adjacent[node]){
                result += indSet(i, 0);
            }
            return result + cost[node];
        }

        //트리 먼저 만들고 어쩌구저쩌구
    }
}

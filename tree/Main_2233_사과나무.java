package tree;

import java.io.*;
import java.util.*;

public class Main_2233_사과나무 {
    static int remove;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String tree = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] root = new int[2*N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        int remX = 0, remY = 0;

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for(int i = 0 ; i < tree.length() ; i++){
            int c = 0;
            if(tree.charAt(i) == '0'){
                c = cnt ++;
                stack.push(c);
            }
            else{
                c = stack.pop();
                if(!stack.isEmpty()) parent[c] = stack.peek();
                else parent[c] = c;
            }
            if(i+1 == X) remX = c;
            if(i+1 == Y) remY = c;
            root[i + 1] = c;
        }

        nearestAnc(remX,remY);

        int ret0=0, ret1=0;
        for(int i = 1 ; i < 2*N + 1 ; i++){
            if(root[i] == remove){
                if(ret0 == 0){
                    ret0 = i;
                }
                else{
                    ret1 = i; break;
                }
            }
        }

        System.out.println(ret0+" "+ret1);
    }

    private static void nearestAnc(int n1, int n2) {
        if(n1 == n2){
            remove = n1; return;
        }
        if(visited[n1] && parent[n1] != n1){
            remove = n1; return;
        }
        if(visited[n2] && parent[n2] != n2){
            remove = n2; return;
        }
        if(parent[n1] == parent[n2]){
            remove = parent[n1]; return;
        }
        visited[n1] = visited[n2] = true;
        nearestAnc(parent[n1], parent[n2]);
    }
}

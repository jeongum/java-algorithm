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
        int[] root = new int[2*N+1];    // 이진 수열에 매핑되는 노드 번호들
        parent = new int[N+1];      // 부모 노드 번호 저장
        visited = new boolean[N+1];
        int remX = 0, remY = 0;     // 잘라야 할 노드 번호
        Stack<Integer> stack = new Stack<>();

        int cnt = 1;
        for(int i = 0 ; i < tree.length() ; i++){
            int c = 0;  // 탐색중인 노드 번호 '나'
            if(tree.charAt(i) == '0'){  // 부모 -> '나'
                c = cnt ++;     // 탐색중인 노드 번호 증가
                stack.push(c);  // 일단 '나'를 스택에 넣음
            }
            else{   // '나' -> 부모
                c = stack.pop();    // '나' = 가장 최근에 스택에 들어간 애
                if(!stack.isEmpty()) parent[c] = stack.peek(); // '나' 전에 스택에 있던 애는 내 부모
                else parent[c] = c; // '나' = 내 부모 -> root
            }
            if(i+1 == X) remX = c;
            if(i+1 == Y) remY = c;
            root[i + 1] = c;
        }

        nearestAnc(remX,remY);

        int ret0=0, ret1=0;
        for(int i = 1 ; i < 2*N + 1 ; i++){
            if(root[i] == remove){
                if(ret0 == 0){  // 아직 처음 저장도 안됐을 경우
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

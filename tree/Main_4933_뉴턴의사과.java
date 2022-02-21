package tree;

import java.io.*;
import java.util.*;

public class Main_4933_뉴턴의사과 {
    static int[] tree1, tree2;  // 각 인덱스에는 부모 노드의 값이 저장
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0 ; tc<T ; tc++){
            tree1 = new int[26+1];  // 노드는 모두 알파벳 대문자라고 했으니, 최대 26개임
            tree2 = new int[26+1];  // 0번 노드는 쓰레기 노드로 아에 쓰지 않음 (아래에 이유 기재)

            makeTree(tree1, br.readLine());
            makeTree(tree2, br.readLine());

            /*
                트리가 똑같다 == 각 노드의 부모가 같다
             */
            boolean isSame = true;
            for(int i = 1 ; i < 27 ; i++){
                if(tree1[i] != tree2[i]){
                    isSame = false;
                    break;
                }
            }
            sb.append(isSame+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void makeTree(int[] tree, String str) {
        StringTokenizer st = new StringTokenizer(str);
        Stack<Integer> stack = new Stack<>();   // 짝을 못지은 노드들이 들어있는 stack
        while(true) {
            String s = st.nextToken();
            if(s.equals("end")) break;
            int i = s.equals("nil")? 0 : s.toCharArray()[0]-'A'+1;  // 알파벳 대문자를 숫자로 변경 'A'->1, 'B'->2...

            if(i!=0 && stack.size() >= 2){  // 현재 넣으려는 노드가 null이 아니고, 이미 스택에 2개 이상 쌓여있다면
                int right = stack.pop();    // 나중에 넣은 노드가 오른쪽 노드 (by.후위순회)
                int left = stack.pop();     // 먼저 넣은 노드가 왼쪽 노드 (by.후위순회)
                tree[right] = i;    // right 노드의 부모는 i
                tree[left] = i;     // left 노드이 부모는 i
            }
            stack.push(i);  // 노드 만든 후, 다시 스택으로 push
        }
        int root = stack.peek();    // 마지막 남아있는 값이 root
        tree[root] = root;  // root의 부모는 root로 설정해놓음
    }
}

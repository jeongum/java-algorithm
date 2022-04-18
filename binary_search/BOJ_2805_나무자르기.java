package binary_search;

import java.io.*;
import java.util.*;

public class BOJ_2805_나무자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        long left = 0;
        long right = tree[N-1]+1;
        long answer = 0;
        while(left <= right){
            long mid = (left + right)/2;
            long cut = 0;
            for(int i =0 ; i < N ; i++){
                cut += Math.max(0, tree[i] - mid);
                if(cut > M) break;
            }
            if(cut >= M){
                answer = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

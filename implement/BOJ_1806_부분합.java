package implement;

import java.util.*;
import java.io.*;
public class BOJ_1806_부분합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int left=0, right = 0;
        int sum = 0, res = Integer.MAX_VALUE;
        while(true){
            if(sum >= S){
                sum -= numbers[left++];
                res = Math.min(res, right-left + 1);
                continue;
            }
            if(right == N) break;
            else sum += numbers[right++];
        }
        System.out.println((res==Integer.MAX_VALUE)?0:res);
    }
}

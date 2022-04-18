package binary_search;

import java.io.*;
import java.util.*;

public class BOJ_10815_숫자카드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < M ; i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N-1;
            boolean flag = false;
            while(left <= right){
                int mid = (left + right) / 2;
                if(card[mid] < num){
                    left = mid+1;
                } else if(card[mid] > num){
                    right = mid-1;
                } else{
                    flag = true;
                    break;
                }
            }
            sb.append((flag)?"1 ":"0 ");
        }

        System.out.println(sb.toString());
    }
}

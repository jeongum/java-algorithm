package binary_search;

import java.io.*;

/*
    https://www.acmicpc.net/problem/1789
*/
public class BOJ_1789_수들의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long left = 0;
        long right = S;
        long answer = 0;
        while(left <= right){
            long mid = (left+right)/2;
            long sum = mid*(mid+1)/2;
            if(sum <= S){
                answer = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

package binary_search;

import java.util.*;
import java.io.*;

public class BOJ_2110_공유기설치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];
        for(int i =0 ; i < N ; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int answer = 0;
        int left = 1;
        int right = house[N-1] - house[0] + 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(canInstall(mid, house) < C){
                right = mid;
            }
            else{
                answer = mid;
                left = mid+1;
            }
        }
        System.out.println(answer);
    }

    private static int canInstall(int mid, int[] house) {
        int cnt = 1;
        int installed = house[0];
        for(int i =0 ; i < house.length ; i++){
            if(house[i] - installed >= mid){
                cnt ++;
                installed = house[i];
            }
        }
        return cnt;
    }
}

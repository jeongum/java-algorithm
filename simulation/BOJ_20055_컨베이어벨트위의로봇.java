package simulation;

import java.util.*;
import java.io.*;

public class BOJ_20055_컨베이어벨트위의로봇 {
    static class Belt{
        int power;
        boolean robot;
        public Belt(int power) {
            this.power = power;
            this.robot = false;
        }
    }
    static int N, K;
    static Belt[] conv;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        conv = new Belt[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < 2*N ; i++){
            conv[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        int stage = 1;
        while(true){
            // 1. 회전
            int p = conv[2*N-1].power;
            boolean r = conv[2*N-1].robot;
            for(int i = 2*N-1 ; i > 0 ; i--){
                conv[i].power = conv[i-1].power;
                conv[i].robot = conv[i-1].robot;
            }
            conv[0].power = p;
            conv[0].robot = r;
            conv[N-1].robot = false;

            // 2. 가장 먼저 올라간 로봇부터, 이동
            for(int i = N-1 ; i > 0 ; i--){
                if(!conv[i].robot && conv[i-1].robot && conv[i].power >= 1){
                    conv[i].power --;
                    conv[i].robot = true;
                    conv[i-1].robot = false;
                }
            }
            conv[0].robot = false;
            conv[N-1].robot = false;

            // 3. 올리는 위치에 로봇 올림
            if(conv[0].power != 0){
                conv[0].robot = true;
                conv[0].power --;
            }
            if(!isValid()) break;
            stage++;
        }
        System.out.println(stage);
    }

    private static boolean isValid() {
        int cnt = 0;
        for(int i = 0 ; i < 2*N ; i++){
            if(conv[i].power <= 0) cnt++;
        }
        return cnt < K;
    }
}

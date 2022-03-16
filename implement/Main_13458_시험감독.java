package implement;

import java.io.*;
import java.util.*;

public class Main_13458_시험감독 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lecture = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            lecture[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = N;
        for(int i = 0 ; i < N ; i++){
            lecture[i] -= B;
            if(lecture[i] >= 0) result += ((lecture[i]+C-1)/C);
        }
        System.out.println(result);
    }
}

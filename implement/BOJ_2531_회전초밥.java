package implement;

import java.io.*;
import java.util.*;

public class BOJ_2531_회전초밥 {
    static int N, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken())-1;
        sushi = new int[N];
        int[] eat = new int[d];
        for(int i =0 ; i < N ; i++){
            sushi[i] = Integer.parseInt(br.readLine())-1;
        }
        int res = 0;
        int cnt = 0;
        for(int i =0 ; i < k ; i++){
            if(eat[sushi[i]]++ == 0) cnt++;
        }
        for(int i =0 ; i < N ; i++){
            if(res <= cnt){     // MAX 값 새로 갱신
                if(eat[c] == 0) res = cnt+1;
                else res = cnt;
            }
            int j = (i+k)%N;  // end 값
            if(eat[sushi[j]] ++ == 0) cnt++;
            if(-- eat[sushi[i]] == 0) cnt--;
        }
        System.out.println(res);
    }
}

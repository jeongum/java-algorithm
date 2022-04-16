package implement;

import java.io.*;
import java.util.*;

public class BOJ_20437_문자열게임2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            List<Integer>[] alpha = new List[26];
            for(int i =0 ; i < 26 ; i ++) alpha[i] = new ArrayList<>();
            int min = Integer.MAX_VALUE;    // 3번 조건
            int max = Integer.MIN_VALUE;    // 4번 조건

            for(int i =0 ; i < W.length() ; i++){
                int idx = W.charAt(i)-'a';
                alpha[idx].add(i);  // 알파벳 배열에 인덱스 추가
                if(alpha[idx].size() == K){ // 3,4번 조건을 만족한다면!
                    int length = i - alpha[idx].get(0) + 1;
                    min = Math.min(length, min);    // 3번 결과값 갱신
                    max = Math.max(length, max);    // 4번 결과값 갱신
                    alpha[idx].remove(0);   // 맨 처음 들어온 인덱스 삭제
                }
            }

            if(min == Integer.MAX_VALUE) sb.append("-1\n");
            else sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }
}

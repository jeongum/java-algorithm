package implement;

import java.io.*;
import java.util.*;

public class BOJ_22233_가희와키워드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> keyword = new HashSet<>();
        for(int i =0 ; i < N ; i++){
            keyword.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < M ; i++){
            String str = br.readLine();
            String[] sarr = str.split(",");
            for(int j =0 ; j < sarr.length ; j++){
                keyword.remove(sarr[j]);
            }
            sb.append(keyword.size()+"\n");
        }
        System.out.println(sb);
    }
}

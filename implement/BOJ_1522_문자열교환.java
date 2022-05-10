package implement;

import java.util.*;
import java.io.*;

public class BOJ_1522_문자열교환 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a_cnt = 0;
        for(int i =0 ; i < str.length() ; i++){
            if(str.charAt(i) == 'a') a_cnt++;
        }
        int result = Integer.MAX_VALUE;
        for(int i =0 ; i < str.length() ; i++){
            int b_cnt = 0;
            for(int j = 0 ; j < a_cnt ; j++){
                if(str.charAt((i + j)%str.length()) == 'b') b_cnt++;
            }
            result = Math.min(result, b_cnt);
        }
        System.out.println(result);
    }
}

package implement;

import java.io.*;
import java.util.*;

public class Main_1032_명령프롬프트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();

        for(int i =0 ; i < N-1 ; i++){
            char[] comp = br.readLine().toCharArray();
            for(int j =0 ; j < pattern.length ; j++){
                if(pattern[j] == '?') continue;
                if(pattern[j] != comp[j]) pattern[j] = '?';
            }
        }

        for(char c : pattern){
            System.out.print(c);
        }
    }
}

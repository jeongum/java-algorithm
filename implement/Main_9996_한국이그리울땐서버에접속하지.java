package implement;

import java.io.*;
import java.util.*;

public class Main_9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        for(int i =0 ; i < N ; i++){
            String file = br.readLine();
            if(file.length() < pattern[0].length()+pattern[1].length()){
                sb.append("NE\n"); continue;
            }
            String fileF = file.substring(0,pattern[0].length());

            String remFile = file.substring(pattern[0].length(), file.length());
            String fileB = remFile.substring(remFile.length()-pattern[1].length(),remFile.length());

            if(fileF.equals(pattern[0]) && fileB.equals(pattern[1])){
                sb.append("DA\n");
            }else
                sb.append("NE\n");
        }
        System.out.println(sb.toString());
    }
}

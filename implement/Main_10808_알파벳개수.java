package implement;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10808_알파벳개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[26];

        for(int i =0 ; i < str.length() ; i++){
            cnt[str.charAt(i)-'a'] ++;
        }

        for(int i : cnt){
            System.out.print(i+" ");
        }
    }
}

package implement;

import java.io.*;
import java.util.*;

public class BOJ_12919_A와B2 {
    static boolean result, finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        result = false;
        game(S, T);
        System.out.println((result)?1:0);
    }

    private static void game(String S, String T) {
        if(S.length() == T.length()){
            if(S.equals(T)){
                result = true;
                finished = true;
            }
            return;
        }
        if(T.charAt(T.length()-1) == 'A') game(S, T.substring(0, T.length()-1));
        if(finished) return;

        String reverse = "";
        for (int i = T.length() - 1; i >= 0; i--) reverse = reverse + T.charAt(i);
        if(reverse.charAt(reverse.length()-1) == 'B') game(S, reverse.substring(0, reverse.length()-1));
        if(finished) return;
    }
}

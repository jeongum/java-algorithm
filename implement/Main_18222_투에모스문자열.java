package implement;

import java.util.*;
import java.io.*;

public class Main_18222_투에모스문자열 {
    static int res = 0;
    static long[] pow;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        pow = new long[64];

        pow[0] = 1;
        for(int i = 1 ; i < 64 ; i++){
            pow[i] = pow[i-1]*2;
        }

        System.out.println(toemos(n));
    }

    private static int toemos(long n) {
        if(n == 1){
            return 0;
        }
        for(int i =0 ; i < 64 ; i++){
            if(pow[i] >= n) return 1 - toemos(n - pow[i-1]);
        }
        return 0;
    }

}

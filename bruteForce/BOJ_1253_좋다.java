package bruteForce;

import java.util.*;
import java.io.*;

public class BOJ_1253_좋다 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        HashMap<Integer, HashSet<Integer>> sums = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

}

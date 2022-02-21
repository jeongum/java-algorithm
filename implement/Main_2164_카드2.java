package implement;

import java.util.*;
import java.io.*;

public class Main_2164_카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> card = new ArrayDeque<>();
        for(int i = 1; i <= n ; i++){
            card.offer(i);
        }

        while(card.size()>1){
            card.poll();
            card.offer(card.poll());
        }

        System.out.println(card.poll());
    }
}

package implement;

import java.io.*;
import java.util.*;

public class Main_20546_기적의매매법 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seed = Integer.parseInt(br.readLine());
        int[] stock = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < 14; i++){
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int jSeed = seed;
        int jStock = 0;
        int sSeed = seed;
        int sStock = 0;
        int up = 0;
        int down = 0;

        for(int i =0 ; i < 14 ; i++){
            if((jSeed / stock[i]) > 0){     // 준현이가 지금 구매할 수 있으면 구매!
                int amount = jSeed / stock[i];
                jStock += amount;
                jSeed -= (amount * stock[i]);
            }

            if(i!=0) {
                if (stock[i - 1] < stock[i]) {
                    up++; down = 0;
                }
                else if(stock[i - 1] > stock[i]){
                    down++; up = 0;
                }
                else{
                    down = 0; up = 0;
                }
            }

            if(up >= 3){
                sSeed += (sStock*stock[i]);
                sStock = 0;
            }
            else if(down >= 3){
                int amount = sSeed / stock[i];
                sStock += amount;
                sSeed -= (amount * stock[i]);
            }
        }

        int jTotal = jSeed + jStock*stock[13];
        int sTotal = sSeed + sStock*stock[13];

        System.out.println(jTotal==sTotal?"SAMESAME":(jTotal>sTotal)?"BNP":"TIMING");

    }
}

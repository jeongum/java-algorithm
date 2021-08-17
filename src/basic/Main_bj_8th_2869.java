package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_bj_8th_2869 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int day = Integer.parseInt(st.nextToken());
		int night = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int date = (height - night) / (day - night) ;

		if( (height - night) % (day-night) != 0) date ++;
		
		System.out.println(date);
	}
}

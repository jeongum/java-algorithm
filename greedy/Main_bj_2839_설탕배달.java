package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int three = 0;
		int five = n/5;
		
		while(five>=0) {
			int rem = n-(five*5);
			if(rem%3 == 0) {
				three = rem/3;
				break;
			}
			else five--;
		}
		if(five == -1 && three == 0) System.out.println("-1");
		else System.out.println(three+five);
	}
}

package basic;

import java.util.Scanner;

public class Main_bj_7th_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] strToChar = str.toCharArray();
		int cnt = 0;
		
		for(int i =0 ; i < strToChar.length ; i++) {
			if(strToChar[i]=='=') {
				if(i>=2 && strToChar[i-1] == 'z' && strToChar[i-2] == 'd') cnt--;
				continue;
			}
			else if (strToChar[i] == '-') continue;
			else if(strToChar[i] == 'j' && i>=1 ) {
				if(strToChar[i-1] == 'l' || strToChar[i-1] == 'n') continue;
			}
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}

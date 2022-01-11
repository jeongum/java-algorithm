
package basic;

import java.util.Scanner;

public class Main_bj_7th_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] strToArr = str.toCharArray();
		int[] charCnt = new int[26];
		
		for(int i =0 ; i < strToArr.length ; i++) {
			if(65<=strToArr[i]  &&  strToArr[i]<=90) {
				charCnt[strToArr[i] - 65] ++;
			}
			else charCnt[strToArr[i]-97] ++;
		}
		int max = Integer.MIN_VALUE;
		int idx =0;
		boolean isSame = false;
 		for(int i =0 ; i < charCnt.length ; i++) {
			if(max < charCnt[i]) {
				max = charCnt[i];
				idx = i;
				isSame = false;
			}

			else if(max == charCnt[i]) isSame = true;
		}
		if(isSame) System.out.println("?");
		else  System.out.println((char)(idx+'A'));
		sc.close();
	}
}

package KakaoBlindRecruitMent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2018_다트게임 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dartResult = br.readLine();
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		/* 구현 시작 */
		int[] ans = new int[3];
		int idx = 0;
		for(int i =0 ; i < 3 ; i++) {
			int s = (dartResult.charAt(idx+1) != '0')? dartResult.charAt(idx) -'0' : 10;
			idx = (s == 10)? idx+2 : idx+1;
			char b = dartResult.charAt(idx++);
			char o = (idx<dartResult.length() && (dartResult.charAt(idx) == '*'||dartResult.charAt(idx) == '#' ))? dartResult.charAt(idx++):0;
			switch(b) {
			case 'S': ans[i] = s; break;
			case 'D': ans[i] = s*s; break;
			case 'T': ans[i] = s*s*s; break;
			}
			if(o != 0) {
				switch(o) {
				case '*':
					if(i>0) ans[i-1] *= 2;
					ans[i] *= 2;
					break;
				case '#':
					ans[i] *=-1;
					break;
				}
			}
		}
		for(int i =0 ; i < 3 ;i++) answer += ans[i];
		/* 구현 끝 */
		return answer;
	}
}

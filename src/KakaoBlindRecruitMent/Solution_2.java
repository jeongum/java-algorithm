package KakaoBlindRecruitMent;

import java.util.*;
import java.io.*;

public class Solution_2 {
   public static int solution(int n, int k) {
	    StringBuilder sb = new StringBuilder();
		String conv = null;
	    int answer = 0;
		
		int cur = n;
		while(cur > 0) {
			sb.append(cur%k);
			cur /= k;
		}
		conv = sb.reverse().toString();
		
		int start = 0;
		int end = 0;
		if(conv.length() == 1) {
			if(isPrimenumber(Integer.parseInt(conv))) answer++;
		}
		else {
			while(end < conv.length()) {
				if(conv.charAt(end) == '0'  && end > start) {
					int tmp = Integer.parseInt(conv.substring(start, end));
					if(isPrimenumber(tmp)) {
						answer ++;
					}
					start = end;
				}
				end++;
			}
			if(end > start) {
				long tmp = Long.parseLong(conv.substring(start, end));
				if(isPrimenumber(tmp)) answer ++;
			}
		}
        return answer;
    }
   
	private static boolean isPrimenumber(long tmp) {
		if(tmp == 1  || tmp == 0) return false;
		int n = (int)Math.sqrt(tmp);
		for(int i = 2; i <= n ; i++) {
			if(tmp % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(2,10));
	}
}

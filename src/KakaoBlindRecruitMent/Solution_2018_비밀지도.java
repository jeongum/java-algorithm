package KakaoBlindRecruitMent;

import java.io.*;
import java.util.*;

public class Solution_2018_비밀지도 {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] ans = new int[n];
        for(int i =0 ; i < n ; i++) {
        	ans[i] = (arr1[i] | arr2[i]);
        }
        for(int i =0 ; i < n ; i++) {
        	char[] tmp = new char[n];
        	Arrays.fill(tmp, ' ');
        	int rem = ans[i];
        	int idx = 0;
        	while(rem>0) {
        		tmp[n-(idx++)-1] = (rem%2==0)?' ':'#';
        		rem/=2;
        	}
        	answer[i] = new String(tmp);
        }
        return answer;
    }
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		String[] answer = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(answer));
	}
}

package stack;

import java.io.*;
import java.util.*;

public class Main_bj_1874_스택수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i =0 ;i < n ; i++) arr[i] =  Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int i;
		
		for(i =0 ; i < n ; i++) {
			if(stack.isEmpty()) {
				if(cnt>arr[i]) break;
				stack.push(cnt++);
				sb.append("+\n");
			}
			if(arr[i] > stack.peek()) {
				if(cnt > arr[i]) break;
				while(stack.peek() != arr[i]) {
					stack.push(cnt++);
					sb.append("+\n");
				}
			}
			else if(arr[i] < stack.peek()) {
				while(stack.peek() != arr[i]) {
					stack.pop();
					sb.append("-\n");
				}
			}
			if(arr[i] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			}
		}
		if(i != n || !stack.isEmpty()) System.out.println("NO");
		else System.out.print(sb.toString());
	}
}

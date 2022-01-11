package stack;

import java.io.*;
import java.util.*;

public class Solution_d4_1223_계산기2 {
	static Stack<Character> stack ;
	static Stack<Integer> res ;
	static int n;
	static char[] carr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int T = 1 ; T<=10 ; T++) {
			n = Integer.parseInt(br.readLine());
			carr = new char[n];
			stack = new Stack<>();
			res = new Stack<>();
			toPostfix(br.readLine());
			sb.append("#").append(T).append(" ").append(Cal()).append("\n");			
		}
		System.out.println(sb.toString());
	}
	
	//후위표기식 계산
	private static int Cal() {
		for(int i =0 ; i < n ; i++) {
			if(carr[i] == '+') res.push(res.pop()+res.pop());
			else if(carr[i] == '*') res.push(res.pop()*res.pop());
			else res.push(carr[i]-'0');
		}
		return res.pop();
	}
	
	//후위표기식 변환
	private static void toPostfix(String str) {
		int idx =0;
		for(int i =0 ; i < n ; i++) {
			if(str.charAt(i)=='+' || str.charAt(i)=='*') {
				while(!stack.isEmpty() && canPop(str.charAt(i))) {	//자신보다 낮은 우선순위의 연산자를 만날때까지 pop
					carr[idx++] = stack.pop(); 
				}
				stack.push(str.charAt(i));	//자기자신은 스택에 push
			}
			else carr[idx++] = str.charAt(i);	//숫자라면 carr배열에 바로 출력
		}
		while(!stack.isEmpty()) carr[idx++] = stack.pop();	//스택에 남아있던 연산자들 모두 출력
	}
	
	//우선순위 판별
	private static boolean canPop(char c) {
		if(c == '+') return true;	// 현재 문제에서 +보다 낮은 우선순위의 연산자는 없으므로 계속 pop
		if(stack.peek() == '*') return true;	//자신과 같은 연산자여야만 pop(->+는 자신보다 낮은 연산자이므로)
		else return false;
	}
}

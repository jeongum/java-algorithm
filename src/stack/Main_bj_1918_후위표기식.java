package stack;

import java.io.*;
import java.util.*;

public class Main_bj_1918_후위표기식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Stack<Character> operator = new Stack<>();
		
		String formula = br.readLine();
		
		for(int i = 0 ; i < formula.length() ; i++) {
			char op = formula.charAt(i);
			if('A'<=op && op<='Z') {
				sb.append(op);
			}
			else {
				if(op == '(') {
					operator.push(op);
				}
				else if(op == ')') {
					char c;
					while((c = operator.pop()) != '(') sb.append(c);
				}
				else {
					while(!operator.isEmpty() && Priority(operator.peek())>= Priority(op))
						sb.append(operator.pop());
					
					operator.push(op);
				}
			}
		}
		while(!operator.isEmpty()) sb.append(operator.pop());
		System.out.println(sb.toString());
	}
	
	public static int Priority(char c) {
		if(c == '*' || c=='/') return 2;
		else if(c == '+' || c=='-') return 1;
		else return 0;
	}
}

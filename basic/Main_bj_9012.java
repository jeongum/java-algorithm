package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		end:for(int t = 1; t<=T ; t++) {
			char[] carr = br.readLine().toCharArray();
			Stack<String> stack = new Stack<>();
			for(int i =0 ; i < carr.length ; i++) {
				if(carr[i] == '(') stack.push("(");
				else if(carr[i] == ')') {
					if(stack.empty()) {
						System.out.println("NO");
						continue end;
					}
					stack.pop();
				}
			}
			if(stack.empty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

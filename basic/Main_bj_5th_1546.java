package basic;

import java.util.Scanner;

public class Main_bj_5th_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] arr = new double[n];
		double max = Integer.MIN_VALUE;
		double avg=0;
		for(int i =0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>=max) max = arr[i];
		}
		
		for(int i = 0 ; i< n ; i++) {
			avg = arr[i]/max * 100;
		}
		
		System.out.println((double)avg/(double)n);
	}
}

package basic;

import java.util.Scanner;

public class Main_bj_5th_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i =0 ; i < t ; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			double avg = 0;
			for(int j =0 ;j < n ;j++) {
				arr[j] = sc.nextInt();
				avg += arr[j];
			}
			avg /= n;
			int cnt=0;
			for(int j =0 ;j < n ; j++) {
				if(arr[j]>avg) cnt++;
			}
			System.out.printf("%.3f%%%n", (double)cnt/(double)n * 100.0);
		}
	}
}

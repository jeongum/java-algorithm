package tree;

import java.util.*;
import java.io.*;

public class Main_bj_5639_이진검색트리 {
	public static void main(String[] args) {
		int[] tree = new int[10000];
		int size = 0;
		Scanner sc = new Scanner(System.in);
		tree[size++] = Integer.parseInt(sc.nextLine());
		while(sc.hasNextLine()) {
			int n = Integer.parseInt(sc.nextLine());
			for(int i =0 ; i<size ; i++) {
				if(tree[i] > n) break;
			}
		}
	}
}

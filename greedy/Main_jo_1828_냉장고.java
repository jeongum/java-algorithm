package greedy;

import java.io.*;
import java.util.*;

public class Main_jo_1828_냉장고 {
	static class Material implements Comparable<Material>{
		int min, max;
		public Material(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(Material o) {
			int val = this.max - o.max;
			if(val != 0) return val;
			
			return this.min - o.min;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Material[] mat = new Material[n];
		for(int i =0 ; i< n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			mat[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(mat);
		int max = 0;
		int cnt = 1;
		for(int i =1 ; i < mat.length ; i++) {
			if(max<mat[i].min) {
				cnt++;
				max = mat[i].max;
			}
		}
		System.out.println(cnt);
	}
}

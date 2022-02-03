package divisionAndConquest;

import java.io.*;

public class Main_bj_1992_쿼드트리 {
	static StringBuilder sb;		//결과값 저장 변수
	static int[][] arr;				
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j< N; j++) {
				arr[i][j] = str.charAt(j)-'0';			//문자형->정수형 변환
			}
		}
		sb = new StringBuilder();
		quardTree(N, 0, 0);
		System.out.println(sb.toString());
	}
	static boolean canZip(int size, int ci, int cj) {
		int tmp = arr[ci][cj];
		for(int i =0 ; i < size; i++) {
			for(int j =0 ; j<size ; j++) {
				if(tmp != arr[ci+i][cj+j])
					return false;
			}
		}
		return true;
	}
	static void quardTree(int size, int ci, int cj) {
		if(canZip(size, ci, cj)) {		//압축할 수 있는지 => 범위내 모든 숫자가 같은지 판별
			sb.append(arr[ci][cj]);		//같다면, sb에 바로 저장
			return;
		}
		sb.append('(');					//분할 시, ( 삽입 후 연산
		quardTree(size/2, ci, cj);		//왼쪽 위
		quardTree(size/2, ci, cj+size/2);	//오른쪽 위
		quardTree(size/2, ci+size/2, cj);	//왼쪽 아래
		quardTree(size/2, ci+size/2, cj+size/2);	//오른쪽 아래
		sb.append(')');		
	}
}

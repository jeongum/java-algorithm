package graph;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws Exception
	{
		/* 입력받기 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			List<int[]> map = new ArrayList<>();	// 건물의 좌표를 저장해놓은 List
			boolean[][] canGo = new boolean[n+2][n+2];	// 건물 사이를 맥주 한박스로 갈 수 있는지를 저장하는 boolean 배열
														// 다른 floyd를 활용한 문제의 경우, 간선의 가중치가 중요한 요인으로 작용하여 int배열이 필요하나,
														// 현재 문제의 경우, 단순히 범위 안에 있는지 없는지만 중요하므로 boolean타입으로 해결 가능
			for(int i =0 ; i < n+2 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
			
				map.add(new int[] {x,y});	//건물의 좌표를 입력받아 저장
			}
			
			for(int i = 0 ; i < n+2 ; i++) {	// n(편의점 개수) + 집 + 페스티벌 -> n+2개의 정점
				for(int j = 0 ; j < n+2 ; j++) {	// n(편의점 개수) + 집 + 페스티벌 -> n+2개의 정점
					int[] start = map.get(i);
					int[] end = map.get(j);
					int dis = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);	// 정점 사이의 거리-> L1
					if(dis <= (50*20)) {	// 정점사이의 거리가 맥주 한박스로 갈 수 있는 거리(50*20)보다 작을 경우 
						canGo[i][j] = true;	// 맥주와 함께 행복하게 갈 수 있음
					}
				}
			}
			
			/* Floyd 알고리즘 */
			for(int k = 0; k < n+2 ; k++) {	// '경'유지
				for(int i =0 ; i < n+2 ; i++) {	// '출'발지
					for(int j = 0 ; j < n+2 ; j++) {	// '도'착지
						/*
						 * 출발지-경유지를 맥주와 함께 갈 수 있고 ( canGo[i][k] == true )
						 * 경유지-도착지를 맥주와 함께 갈 수 있다면 (canGo[i][k] == true )
						 * 중간 편의점에서 맥주를 20병으로 다시 채워 갈 수 있으므로, 
						 * 최종적으로 출발지-도착지 사이를 맥주와 함께 갈 수 있다. 
						 */
						if(canGo[i][k] && canGo[k][j]) canGo[i][j] = true;	
					}
				}
			}
			// 0: 집 - n+1: 페스티벌 사이를 맥주와 함께 갈 수 있는지 여부가 저장되어 있는 인덱스
			sb.append(canGo[0][n+1]? "happy\n":"sad\n");
		}
		System.out.println(sb.toString());
	}

}

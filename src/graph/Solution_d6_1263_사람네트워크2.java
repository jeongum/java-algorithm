package graph;

import java.io.*;
import java.util.*;

public class Solution_d6_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception{
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());		
		for(int tc = 1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());	// 사람 수 N (정점의 개수)
			int[][] graph = new int[N][N];	// 사람 사이의 CC를 저장할 배열
			for(int i =0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());	// row by row로 되어있는 2차원 배열 입력 받기
					if(i!=j && graph[i][j] == 0) {	// 자기 자신으로의 간선이 아니며, 정점 사이의 간선 (직접연결)이 없는 경우 
											// 모든 간선의 가중치가 1이기 때문에, 나올 수 있는 가장 최대 거리는 N
						graph[i][j] = N+1;	// Overflow방지를 위해, N+1을 MAX_VALUE대신 최댓값으로 설정 
					}
				}
			}
			
			/* Floyd 알고리즘 */
			for(int k = 0 ; k < N ; k++) {	// '경'유지
				for(int i = 0 ; i < N ; i++) {	// '출'발지 
					for(int j = 0 ; j < N ; j++) {	// '도'착지
						//경유지를 통한 새로운 거리 vs 현재까지의 최적 거리
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);		
					}
				}
			}
			
			int result = Integer.MAX_VALUE;	// 최소값을 찾기 위해 result를 MAX_VALUE로 설정
			for(int i = 0 ; i < N ; i++) {	
				int tmp = 0;	// i번 사람의 최종 CC => CC(i)
				for(int j =0 ; j < N ; j++) {
					tmp += graph[i][j];		
				}
				result = Math.min(result, tmp);	//최소 CC를 가진 사람의 CC값을 result 저장
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}

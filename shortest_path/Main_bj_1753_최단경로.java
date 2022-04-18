package shortest_path;

import java.util.*;
import java.io.*;

class Element{
	int to, weight;
	public Element(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
public class Main_bj_1753_최단경로 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		List<Element>[] adjList = new ArrayList[V+1];
		for(int i =1 ; i < V+1 ; i++) {
			adjList[i] = new ArrayList<>();
		}
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Element(to, weight));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		int min = 0, current = 1;
		for(int i =1 ; i <= V ; i++) {
			min = Integer.MAX_VALUE;
			for(int j =1  ; j <= V ; j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			for(int j =0 ; j < adjList[current].size() ; j++) {
				if(!visited[adjList[current].get(j).to] && distance[adjList[current].get(j).to] > min+adjList[current].get(j).weight) {
					distance[adjList[current].get(j).to] = min+adjList[current].get(j).weight;
				}
			}
		}
		
		for(int i = 1; i <= V ; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}

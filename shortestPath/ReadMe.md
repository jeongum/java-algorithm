# 최단 경로

: 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치 합이 최소인 경로

## Dijkstra 알고리즘

- 하나의 시작 정점에서 끝 정점까지의 최단 경로
- 음의 가중치를 허용하지 않음
- Prim알고리즘과 유사

```java
public class Dijkstra {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0; //시작점 인덱스
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V]; // 정점 사이의 가중치 저장
		int[] distance = new int[V]; // 시작 정점에서의 거리
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=0; j<V; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			if(current == end){ // 선택 정점이 도착정점이면 탈출.
				break;
			}
			
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current][c] != 0
						&&  distance[c] > min+matrix[current][c]){
					distance[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(distance[end]);
		
	}

}
```

---

## 플로이드-워샬 알고리즘

- 모든 정점에 대한 최단 경로
- 다익스트라의 시간복잡도와 동일하지만 매우 간단함!!!!

```java
D[i][j] = 정점 i에서 정점 j로의 최소비용
AllPairsShortest(D[][])
	For k in 1->n
		For i in 1->n
			For j in 1->n
				D[i][j] = min(D[i][k]+D[k][j], D[i][j])
```
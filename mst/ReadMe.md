# **최소 신장 트리(MST)**

- 최소 비용 그래프
  - 모든 정점을 연결하는 간선들의 가중치의 합이 최소가 되는 트리
  - 두 정점 사이의 최소 비용의 경로 찾기 => 최단거리
- 신장 트리
  - n개의 정점과 n-1개의 간선으로 이루어진 트리 (무향 그래프)
- 최소 신장 트리(MST)
  - 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소인 신장 트리

---

## **KRUSKAL**

간선을 하나씩 선택해서 MST를 찾음

1. 최초, 모든 간선을 가중치에 따라 오름차순으로 정렬
2. 가중치가 가장 낮은 간선부터 선택하면서 트리를 증가 -> 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택
3. n-1개의 간선이 선택될 때까지 2를 반복

```java
public class Kruskal{

	static class Edge implements Comparable<Edge>{
		
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight; // 간선의 부호가 모두 같을때
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents
	private static void makeSet() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 parent 찾기
	private static int find(int a) {
		if(a==parents[a]) return a; 
		return parents[a] = find(parents[a]); 
	}

	// 두 집합 합치기
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList; // 인접 리스트
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 간선리스트 작성
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start,end,weight);
		}
		
		Arrays.sort(edgeList); // 오름차순 정렬
		
		make(); // 모든 정점을 각각으로 집합으로 만들고 출발
		
		// 간선 하나씩 시도하여 트리 생성
		int cnt = 0,result = 0;
		for (Edge edge : edgeList) {
			if(union(edge.start, edge.end)) { // 사이클이 생성되지 않는다면
				result += edge.weight;
				if(cnt++ == V-1) break; // 신장트리 완성
			}
		}
		System.out.println(result);	
	}
}
```

---

## PRIM 알고리즘

하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 찾음

1. 임의 정점을 하나 선택해서 시작
2. 선택 정점과 인접한 정점들 중 최소 비용의 간선이 존재하는 정점 선택
3. 모든 정점이 선택될 때 까지 1, 2 과정 반복

> MST를 만들기 위해 선택된 정점 집합 & 선택 되지 않는 정점 집합
→ 서로소인 2개의 집합 정보 유지
>

```java
public class Prim{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N]; // 그래프
		boolean[] v = new boolean[N]; // 방문여부 확인 
		int[] minEdge = new int[N]; // 정점 기준, 다른 정점과의 간선 중 최소 비용

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int result = 0, cnt = 0;
		minEdge[0] = 0;
		pq.offer(new int[] { 0, 0 });// 정점 번호, 비용
		while (!pq.isEmpty()) {
			int[] minVertex = pq.poll();
			if (v[minVertex[0]]) continue; // 이미 방문 한 정점이면 continue 
			result += minVertex[1]; // result에 비용 합함
			v[minVertex[0]] = true; // 정점 방문 처리
			if (cnt++ == N - 1) // n-1개의 간선을 연결했을 때, stop
				break;
			for (int j = 0; j < N; j++) {
				if (!v[j] && g[minVertex[0]][j] != 0 ) { // j 정점을 방문하지 않았고, 간선이 연결되어 있는 곳이면
					if(minEdge[j] > g[minVertex[0]][j]){ //  j 정점의 현재 최소 간선 비용 vs 현재 정점-j정점 사이의 비용
						minEdge[j] = g[minVertex[0]][j]; // j 정점의 최소 간선 비용을 현재 정점과의 비용으로 업뎃
						pq.offer(new int[] { j, g[minVertex[0]][j] }); // 다음 방문할 정점으로 offer
					}
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
```
# 그래프

## 너비우선 탐색(BFS)

- 인접한 정점들을 먼저 모두 차례로 방문한 후에, 방문했던 정점을 시작점으로 하여 다시 인접한 정점들을 차례로 방문
- 인접한 정점들에 대해 탐색 한 후, 차례로 너비 우선 탐색 진행 → **Queue(FIFO)**를 사용

```
BFS(G, v) // 그래프 G, 탐색 시작 정점 v
	make Queue
	insert 시작정점 v
	visited[v] <- true
	while(!Queue.isEmpty)
		t <- Queue.poll
		for(t와 연결된 모든 간선에 대해)
			u <- t의 인접 정점
			if(!visited[u])
				insert u
				visited[u] <- true
```

## 깊이우선 탐색(DFS)

- 시작 정점의 한 방향으로 갈 수 있는 경로가 있는 곳까지 깊이 탐색해 가다가 더 이상 갈 곳이 없게 되면, 가장 마지막에 만났던 갈림길 간선이 있는 정점으로 돌아와 다른 방향의 정점으로 탐색을 반복
- 가장 마지막에 만났던 갈림길의 정점으로 되돌아가서 탐색 반복 → **재귀 or 스택(LIFO)**

```
DFS(v) // G: 그래프, v: 탐색정점
	visited[v] <- TRUE
	FOR each all w in adjacency( G, v )
		IF visited[w] != TRUE
			DFS(w)
```
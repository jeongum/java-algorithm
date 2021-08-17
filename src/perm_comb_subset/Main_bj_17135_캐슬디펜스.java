package perm_comb_subset;

import java.util.*;
import java.io.*;

public class Main_bj_17135_캐슬디펜스 {
	static int n,m,d;
	static List<int[]> enemy;
	static int[] archer;
	static int max_kill;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		enemy = new ArrayList<int[]>();
		archer = new int[3];
		max_kill = 0;
		for(int i =0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m ; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					enemy.add(new int[] {i,j});
				}
			}
		}
		attack(0,0);
		System.out.println(max_kill);
	}
	
	public static void attack(int cnt, int start) {
		if(cnt == 3) {		//기저조건: 아처 3명의 위치가 정해졌을 경우
			int tmp_max_kill = 0;
			List<int[]> tmp_enemy = new ArrayList<int[]>();															//enemy를 계속 변경시켜줘야하기 때문에, 기존의 enemy유지 해야함
			for(int i =0 ; i < enemy.size() ; i++) tmp_enemy.add(new int[] {enemy.get(i)[0], enemy.get(i)[1]});		//초기상태의 enemy복사
			while(!tmp_enemy.isEmpty()) {																			//맵에 적들이 없을때까지
				int[][] killed = new int[3][2];																		//궁수가 죽인 적 위치 저장하는 변수
				for(int i =0 ; i < 3 ; i++) {																		//궁수마다 죽일 적 선택
					int min = Integer.MAX_VALUE;		
					for(int j =0 ; j < tmp_enemy.size() ; j++) {													//적 위치마다 저장
						int dis = Math.abs(tmp_enemy.get(j)[0] - n) + Math.abs(tmp_enemy.get(j)[1] - archer[i]);	//적과의 거리 계산
						if(dis<=d && min >= dis ) {			//적과의 거리가 유효값일 때
							if(min == dis && killed[i][1] < tmp_enemy.get(j)[1] ) continue;							//위치가 같을 시, 가장 왼쪽에 있는 적을 kill
							min = dis;
							killed[i] = tmp_enemy.get(j);
						}
					}
				}
				for(int i =0 ; i < 3 ; i++) {						//같은 적을 죽일 수 있기 때문에, 한번에 처리해 주어야 함
					if(tmp_enemy.contains(killed[i])) {				//앞선 궁수가 이미 죽였을 수도 있기 때문에 현재 적이 있는지 체크
						tmp_enemy.remove(killed[i]);				//죽인 적을 리스트에서 삭제
						tmp_max_kill++;								//죽인 횟수 증가
					}
				}
				for(int i =tmp_enemy.size()-1 ; i >=0 ; i--) {		//리스트이기 때문에 뒤에서 부터 삭제
					if(tmp_enemy.get(i)[0] < n-1) 					//맵 밖으로 나가지 않을땐 아래로 한칸 이동
						tmp_enemy.get(i)[0] ++;
					else 
						tmp_enemy.remove(i);						//맵 밖으로 나가는경우 리스트에서 삭제
				}
			}
			max_kill = Math.max(max_kill, tmp_max_kill);			//지금까지 조합중, 가장 많이 죽였던 값 선택
			return;
		}
		for(int i = start; i < m ; i++) {
			archer[cnt] = i;		//아처의 위치
			attack(cnt+1, i+1);
		}
	}
}

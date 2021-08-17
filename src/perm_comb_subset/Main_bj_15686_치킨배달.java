package perm_comb_subset;
import java.io.*;
import java.util.*;

public class Main_bj_15686_치킨배달 {
	//가정집과 치킨집의 수가 정해져있지 않기 때문에 배열대신 List사용
	static List<int[]> home;				//가정집 주소를 저장할 리스트
	static List<int[]> chic;				//치킨집 주소를 저장할 리스트
	static List<int[]> remChic;				//선택한 치킨집 주소를 저장할 리스트
	static int chic_dis;					//결과값: 최단치킨거리
	static int n,m;							//도시 너비, 남겨야하는 치킨집 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		home = new ArrayList<int[]>();
		chic = new ArrayList<int[]>();
		remChic = new ArrayList<int[]>();
		for(int i =0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0 ; j < n ; j++) {
				int  num = Integer.parseInt(st.nextToken());
				if(num == 1) home.add(new int[] {i,j});				//가정집 주소(i,j)를 배열형태로 리스트에 저장
				else if(num == 2) chic.add(new int[] {i, j});		//치킨집 주소(i,j)를 배열형태로 리스트에 저장
			}
		}
		chic_dis = Integer.MAX_VALUE;								//최솟값 비교를 위해 결과값의 초기값을 MAX INTEGER로 설정
		chicDis(0,0);
		System.out.println(chic_dis);
	}
	
	public static void chicDis(int cnt, int start) {
		if(cnt == m) {							//기저조건: 현재 선택한 치킨집 갯수(cnt)가 남겨야하는 치킨집 개수(m)일때
			int chic_dis_tmp = 0;				//선택한 치킨집 개수에 따른 치킨거리를 저장할 변수
			for(int i =0 ; i < home.size() ; i++) {	
				int dis = Integer.MAX_VALUE;	//가정집과 치킨집 사이의 거리를 저장할 변수 	
				for(int j = 0 ; j < remChic.size() ; j++) {			//선택된 치킨집들과의 치킨거리를 계산해 최솟값 찾기
					dis = Math.min(dis, Math.abs(home.get(i)[0]-remChic.get(j)[0])+ Math.abs(home.get(i)[1]-remChic.get(j)[1]));
				}
				chic_dis_tmp += dis;			//치킨거리 계산
			}
			chic_dis = Math.min(chic_dis, chic_dis_tmp);		//지금까지의 조합 중, 가장 작은 치킨거리 값 찾기
			return;
		}
		for(int i = start; i < chic.size() ; i++) {				//치킨집 조합 코드
			if(remChic.size() == cnt) remChic.add(chic.get(i));			
			else remChic.set(cnt, chic.get(i));
			chicDis(cnt+1, i+1);
		}
	}
}

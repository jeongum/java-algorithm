package simulation;

import java.io.*;
import java.util.*;

public class Main_bj_17825_주사위윷놀이 {
	// 맵을 linkedlist로 구현!
	static class Node{		
		int score;
		boolean isEnd, isEmpty;
		Node next, shortcut;	// next: 다음 Node, shortcut: 지름길 Node
		
		Node(int score){
			this.score = score;
			this.isEnd = false;
			this.isEmpty = true;
			this.next = null;
			this.shortcut = null;
		}
		
		Node addNext(int score) {
			Node newNode = new Node(score);
			this.next = newNode;
			return newNode;
		}
		
		static Node getNode(int score) {
			Node tmp = head;
			while(tmp.score != score) {
				tmp = tmp.next;
			}
			return tmp;
		}
	}
	
	static Node head;
	static int[] dice;
	static int[] select;
	static Node[] markers;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for(int i =0 ; i < 10 ; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		makeMap();	// 맵 셋팅
		
		select = new int[10];
		markers = new Node[4];
		play(0);
		System.out.println(result);
	}

	// 각 턴마다 움직일 말 고르는 순열
	private static void play(int idx) {
		if(idx == 10) {	//10번 다 골랐을 때
			Arrays.fill(markers, head);	//말의 초기 위치를 다 head로 조정
			int tmp = move();	// 말 움직여 점수 계산
			result = Integer.max(tmp, result);
			
			// 현재 말의 위치를 reset!
			for(int i =0 ; i < 4 ; i++) {
				markers[i].isEmpty = true;
			}
			
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			select[idx] = i;
			play(idx+1);
		}
	}

	private static int move() {
		int scr = 0;
		for(int i = 0 ; i < 10 ; i++) {	// 턴을 돌며
			Node cur = markers[select[i]];	// 지금 움직일 말의 현재 위치를 받아옴
			cur.isEmpty = true;	// 지금 있었던 곳은 비어있다고 표시
			for(int j =0 ; j < dice[i] ; j++) {	// 주사위 수만큼 움직임
				if(j == 0&& cur.shortcut!=null) {	// 현재 위치가 지름길 갈 수 잇는 위치라면
					cur = cur.shortcut;	//지름길로 이동
				}else {
					cur = cur.next;	// 다음 위치로 이동
				}
			}
			markers[select[i]] = cur;	// 현재 위치 설정
			
			if(!cur.isEmpty && !cur.isEnd) return 0;	// 도착할 위치가 비어있지 않다면 더 볼 필요없이 return
			scr += cur.score;
			cur.isEmpty = false;
		}
		return scr;
	}

	private static void makeMap() {
		head = new Node(0);	// head설정
		Node end = null;
		Node center = new Node(25);
		
		//바깥쪽 맵
		Node tmp = head;
		for(int i = 2; i <=40 ; i+=2) {
			tmp = tmp.addNext(i);
		}
		
		// 0일때 -> 도착지점 // next는 null을 가리키는게 아닌 자기 자신을 가리키도록 함! (nullpointerexception방지)
		end = tmp.addNext(0);
		end.next = end;
		end.isEnd = true;
		
		// 10~25 지름길 설정
		Node n = Node.getNode(10);
		n = n.shortcut = new Node(13);
		n = n.addNext(16);
		n = n.addNext(19);
		n.next = center;

		// 20~25 지름길 설정
		n = Node.getNode(20);
		n = n.shortcut = new Node(22);
		n = n.addNext(24);
		n.next = center;

		// 30~25 지름길 설정
		n = Node.getNode(30);
		n = n.shortcut = new Node(28);
		n = n.addNext(27);
		n = n.addNext(26);
		n.next = center;

		// 25~40길 설정
		n = center.addNext(30);
		n = n.addNext(35);
		n.next = Node.getNode(40);
		
	}
}

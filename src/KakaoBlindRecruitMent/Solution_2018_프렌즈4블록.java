package KakaoBlindRecruitMent;

import java.util.*;
import java.io.*;

public class Solution_2018_프렌즈4블록 {
	
	static int[] di = {0,1,0};
	static int[] dj = {1,0,-1};
	
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] game = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++) {
        	game[i] = board[i].toCharArray();
        }
        for(int i =0 ; i < n ; i++) {
        	for(int j = 0 ; j < m ; j++) {
        		char tmp = game[i][j];
        		boolean flag = false;
        		for(int k = 0; k<3 ; k++) {
        			int ni = i+di[k];
        			int nj = j+dj[k];
        			if(0<=ni&&ni<n && 0<=ni&&ni<n && game[ni][nj] == tmp) continue;
        			else {
        				flag = true;
        				break;
        			}
        		}
        		if(!flag) {
        			for(int k = 0; k<3 ; k++) {
            			int ni = i+di[k];
            			int nj = j+dj[k];
            			visited[ni][nj] = true;
            		}
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE","AAADE","AAABF","CCBBF"};
		System.out.println(solution(m,n,board));
	}

}

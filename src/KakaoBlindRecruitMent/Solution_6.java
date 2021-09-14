package KakaoBlindRecruitMent;

public class Solution_6 {
	
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        for(int i =0 ; i < skill.length ; i++) {
        	int type = skill[i][0];
        	int r1 = skill[i][1];
        	int c1 = skill[i][2];
        	int r2 = skill[i][3];
        	int c2 = skill[i][4];
        	int degree = skill[i][5];
    		
        	
        	for(int j = r1 ; j <= r2 ; j++) {
    			for(int k = c1 ; k <= c2 ; k++) {
    				board[j][k] = (type == 1) ? board[j][k] - degree : board[j][k] + degree ;
    			}
    		}
        	
        }
        for(int i =0 ; i < n ; i++) {
        	for(int j = 0 ; j < m ;j++) {
        		if(board[i][j] >= 1) answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] board  = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(solution(board, skill));
	}

}

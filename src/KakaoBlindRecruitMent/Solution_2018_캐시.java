package KakaoBlindRecruitMent;

import java.io.*;
import java.util.*;

public class Solution_2018_캐시 {
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> queue = new ArrayDeque<>();
        for(int i =0 ; i < cities.length ; i++) {
        	String city = cities[i].toLowerCase();
        	if(!queue.isEmpty() && queue.contains(city)) {
        		queue.remove(city);
        		queue.offer(city);
        		answer += 1;
        	}
        	else {
        		if(queue.size() == cacheSize) {
        			queue.offer(city);
        			queue.poll();
        		}
        		else {
        			queue.offer(city);
        		}
        		answer += 5;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[] cities = new String[n];
		for(int i =0 ;i < n ; i++) {
			cities[i] = br.readLine();
		}
		System.out.println(solution(cacheSize, cities));
	}

}

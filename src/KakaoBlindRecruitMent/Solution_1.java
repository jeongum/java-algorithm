package KakaoBlindRecruitMent;


import java.util.*;
import java.io.*;

public class Solution_1 {
	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new LinkedHashMap<>();
        Map<String, Boolean> isstop = new LinkedHashMap<>();
        Map<String, Integer> ans = new LinkedHashMap<>();
        for(int i =0; i < id_list.length ; i++) {
        	map.put(id_list[i], new ArrayList<>());
        	isstop.put(id_list[i], false);
        	ans.put(id_list[i], 0);
        }
        
        for(int i =0 ; i < report.length ; i++) {
        	String from = report[i].split(" ")[0];
        	String to = report[i].split(" ")[1];
        	if(!map.get(to).contains(from)) {
        		map.get(to).add(from);
        		if(map.get(to).size()>=k) {
        			isstop.put(to, true);
        		}
        	}
        }
        for(String key: map.keySet()) {
        	if(isstop.get(key)) {
        		for(int i =0 ; i < map.get(key).size() ; i++) {
        			ans.put(map.get(key).get(i), ans.get(map.get(key).get(i))+1);
        		}
        	}
        }
        int idx = 0;
        for(String key: ans.keySet()) {
        	answer[idx++] = ans.get(key); 
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach","neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo","muzi neo", "apeach muzi"};
		int k = 2 ;
		
		Arrays.toString(solution(id_list, report, k));
	}

}

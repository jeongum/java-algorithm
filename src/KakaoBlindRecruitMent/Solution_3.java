package KakaoBlindRecruitMent;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution_3 {
	public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int basic_min = fees[0];
        int basic_fee = fees[1];
        int unit_min = fees[2];
        int unit_fee = fees[3];
        
        Map<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Boolean> isIn = new TreeMap<>();
        
        for(int i = 0 ; i < records.length ; i++) {
        	String str_time = records[i].split(" ")[0];
        	int car_num = Integer.parseInt(records[i].split(" ")[1]);
        	boolean inout = (records[i].split(" ")[2].equals("IN"))? true : false;
        	
        	int hour = Integer.parseInt(str_time.split(":")[0]);
        	int min = Integer.parseInt(str_time.split(":")[1]);
        	int time = hour*60 + min;
        	
    		if(inout) {
    			if(map.containsKey(car_num))
    				map.put(car_num, map.get(car_num) + time);
    			else
    				map.put(car_num, time);
    			isIn.put(car_num, true);
    		}
    		else {
    			if(map.containsKey(car_num))
    				map.put(car_num, map.get(car_num) - time);
    			else
    				map.put(car_num, time);
    			isIn.put(car_num, false);
    		}
        }
        
        answer = new int[map.size()];
        

        
        int idx = 0;
        for(Integer key: map.keySet()) {
        	if(isIn.get(key)) {
        		map.put(key, map.get(key) - 1439);
        	}
        	
        	if((map.get(key))* -1 <= basic_min) {
        		answer[idx++] = basic_fee;
        	}
        	else {
        		int tmp = map.get(key)*-1;
        		tmp -= basic_min;
        		answer[idx] += basic_fee;
        		int unit = (int)Math.ceil((double)tmp/unit_min);
        		answer[idx] += (unit_fee*unit);
        		idx++;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] fees = {120, 0, 60, 591};
		String[] records =  {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}
}

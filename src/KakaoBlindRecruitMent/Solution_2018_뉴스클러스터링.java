package KakaoBlindRecruitMent;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution_2018_뉴스클러스터링 {
    public static int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0 ; i < str1.length()-1; i++) {
        	if(!isAlpha(str1.charAt(i), str1.charAt(i+1))) continue;
        	String substr = str1.substring(i, i+2);
        	if(map1.containsKey(substr)) map1.replace(substr, map1.get(substr)+1);
        	else map1.put(substr, 1);
        }
        for(int i = 0 ;  i < str2.length()-1 ; i++) {
        	if(!isAlpha(str2.charAt(i), str2.charAt(i+1))) continue;
        	String substr = str2.substring(i, i+2);
        	if(map2.containsKey(substr)) map2.replace(substr, map2.get(substr)+1);
        	else map2.put(substr, 1);
        }

        if(map1.size() == 0 && map2.size() == 0) return 65536;
        
        Iterator<Entry<String, Integer>> iter1 = map1.entrySet().iterator();
        int union = 0;
        int inter = 0;
        int sum1 = 0, sum2 = 0;
        while(iter1.hasNext()) {
        	Map.Entry<String, Integer> ent1 = iter1.next();
        	Iterator<Entry<String, Integer>> iter2 = map2.entrySet().iterator();
        	sum1 += ent1.getValue();
        	sum2 = 0;
        	while(iter2.hasNext()) {
        		Map.Entry<String, Integer> ent2 = iter2.next();
        		sum2 += ent2.getValue();
        		if(ent1.getKey().equals(ent2.getKey())) {
        			inter += Integer.min(ent1.getValue(), ent2.getValue());
        		}
        	}
        }
        union = sum1+sum2 -inter;
        answer = (int)((double)inter/(double)union * 65536);
        return answer;
    }
    
    public static boolean isAlpha(char n, char m) {
    	if(('a'<=n && n<='z')&& n!=' ') ;
    	else return false;
    	if(('a'<=m && m<='z') && m != ' ') ;
    	else return false;
    	return true;
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine(),br.readLine()));
	}

}

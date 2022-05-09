package brute_force;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1474_밑줄 {
    static int N, M, len = 0;
    static String[] strs;
    static String result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 밑줄 문자열들이 포함된 배열 선언
        strs = new String[N*2-1];

        for(int i =0 ; i < N ; i++){
            String str = br.readLine();
            strs[i*2] = str;    // 단어 입력(사이에 밑줄 문자열이 들어간다는 가정하에 i*2번째 원소에 삽입)
            len += str.length();    // 단어의 길이 재기
        }

        StringBuilder def = new StringBuilder();
        for(int i = 0 ; i < Math.floor((M-len)/(N-1)) ; i++){   // 최대, 최소 차이가 1이므로 (M-len)/(N-1)을 버림한만큼 기본적으로 가지고 있어야 함
            def.append("_");
        }

        for(int i = 1 ; i < N*2 -1 ; i+=2){
            strs[i] = def.toString();   // 배열에 기본 _ 문자열 추가
            len += def.length();
        }

        makeSentence(0,1);  // subset

        System.out.println(result);

    }

    private static void makeSentence(int cnt, int pos) {
        if(cnt == M-len){   // 기저조건: _가 추가된 총 문자 길이가 M일 때
            StringBuilder sb = new StringBuilder(); // 완성된 문자열 저장
            for(String str : strs){
                sb.append(str);
            }
            if(result == null) result = sb.toString();
            else if(result.compareTo(sb.toString()) > 0){   // 기존 result와 사전순 비교
                result = sb.toString();
            }
            return;
        }

        if(pos >= N*2-1) return;    // 범위 밖인 경우

        makeSentence(cnt, pos+2);   // 현재 위치에 _를 추가하지 않고 다음위치로 이동
        strs[pos] = strs[pos].concat("_");  // 현재 위치에 _를 추가
        makeSentence(cnt + 1, pos+2);   // 추가한 채로 다음 위치로 이동
        strs[pos] = strs[pos].substring(0,strs[pos].length()-1);    // 다시 원상복구
    }
}
